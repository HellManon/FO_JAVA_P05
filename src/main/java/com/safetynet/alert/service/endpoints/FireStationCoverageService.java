package com.safetynet.alert.service.endpoints;

import com.safetynet.alert.dao.JSONReader;
import com.safetynet.alert.dao.Reader;
import com.safetynet.alert.dto.FireCoverage;
import com.safetynet.alert.dto.PersonCover;
import com.safetynet.alert.model.FireStation;
import com.safetynet.alert.model.MedicalRecord;
import com.safetynet.alert.model.Person;
import com.safetynet.alert.service.PersonAge;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service that allows to get a person's list with their name, address and phone number, who is covered by a specified station.
 */
@Data
@Service
public class FireStationCoverageService implements IFireStationCoverageService {
    private static final Logger logger = LogManager.getLogger("FireStationCoverageService");

    @Autowired
    JSONReader jsonReader;

    PersonAge personAge = new PersonAge();

    private Map<String, FireStation> map;
    private List<MedicalRecord> listMedical;
    private List<Person> listPerson;

    public FireStationCoverageService(Reader jsonReader) throws IOException {
        this.map = jsonReader.readFireStation();
        this.listMedical = jsonReader.readMedicalRecord();
        this.listPerson = jsonReader.readPerson();
    }

    public List<FireCoverage> getFireStationCoverage(String stationNumber) {
        logger.debug("Entering getFireStationCoverage");
        List<PersonCover> getPersonCover = map.get(stationNumber).getAddresses().stream()
                .flatMap(address -> listPerson.stream()
                        .filter(person -> person.getAddress().contains(address))
                        .map(person ->
                        {
                            PersonCover personCover = new PersonCover();
                            personCover.setFirstName(person.getFirstName());
                            personCover.setLastName(person.getLastName());
                            personCover.setAddress(person.getAddress());
                            personCover.setPhone(person.getPhone());
                            return personCover;
                        })).collect(Collectors.toList());
        logger.debug("Count Adults and Children");
        List<MedicalRecord> listMedicalForPersonCover = listMedical.stream()
                .filter(medicalRecord -> getPersonCover.stream()
                        .anyMatch(person -> medicalRecord.getFirstName().contains(person.getFirstName()) && medicalRecord.getLastName().contains(person.getLastName()))).collect(Collectors.toList());
        int numberOfAdults = getNumberOfAdults(listMedicalForPersonCover);
        int numberOfChildren = getNumberOfChildren(listMedicalForPersonCover);
        logger.debug("Success count");
        List<FireCoverage> listCoverage = new ArrayList<>();
        listCoverage.add(new FireCoverage(getPersonCover, numberOfAdults, numberOfChildren));

        logger.info("FireStation Coverage find successfully");
        return listCoverage;
    }

    private int getNumberOfAdults(List<MedicalRecord> listMedicalForPersonCover) {
        int numberOfAdults = 0;
        for (MedicalRecord person : listMedicalForPersonCover) {
            int age = personAge.getPersonAge(person.getBirthDate());
            if (age > 18) {
                numberOfAdults++;
            }
        }

        return numberOfAdults;
    }

    private int getNumberOfChildren(List<MedicalRecord> listMedicalForPersonCover) {
        int numberOfChildren = 0;
        for (MedicalRecord person : listMedicalForPersonCover) {
            int age = personAge.getPersonAge(person.getBirthDate());
            if (age <= 18) {
                numberOfChildren++;
            }
        }

        return numberOfChildren;
    }
}
