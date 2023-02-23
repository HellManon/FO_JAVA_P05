package com.safetynet.alert.service.endpoints;

import com.safetynet.alert.dao.JSONReader;
import com.safetynet.alert.dao.Reader;
import com.safetynet.alert.dto.PhoneAndMedical;
import com.safetynet.alert.dto.PhoneAndMedicalWithStation;
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
 * Service that allows to get a Medical Record's list with phone number from person who lived in specified address.
 */
@Data
@Service
public class FireService implements IFireService {
    private static final Logger logger = LogManager.getLogger("FireService");

    @Autowired
    JSONReader jsonReader;

    PersonAge personAge = new PersonAge();

    private List<Person> listPerson;
    private Map<String, FireStation> map;
    private List<MedicalRecord> listMedical;

    public FireService(Reader jsonReader) throws IOException {
        this.listPerson = jsonReader.readPerson();
        this.map = jsonReader.readFireStation();
        this.listMedical = jsonReader.readMedicalRecord();
    }

    public List<PhoneAndMedicalWithStation> getFire(String address) {
        logger.debug("Entering getFire");
        List<PhoneAndMedical> getPhoneAndMedicalList = listPerson.stream().filter(person -> person.getAddress().contains(address))
                .flatMap(medicalRecord -> listMedical.stream()
                        .filter(person -> person.getFirstName().contains(medicalRecord.getFirstName()) && person.getLastName().contains(medicalRecord.getLastName()))
                        .map(personAndMedical ->
                        {
                            PhoneAndMedical phoneAndMedical = new PhoneAndMedical();
                            phoneAndMedical.setFirstName(personAndMedical.getFirstName());
                            phoneAndMedical.setLastName(personAndMedical.getLastName());
                            phoneAndMedical.setPhone(medicalRecord.getPhone());
                            phoneAndMedical.setAge(String.valueOf(personAge.getPersonAge(personAndMedical.getBirthDate())));
                            phoneAndMedical.setMedications(personAndMedical.getMedications());
                            phoneAndMedical.setAllergies(personAndMedical.getAllergies());
                            return phoneAndMedical;
                        })).collect(Collectors.toList());
        logger.debug("Add numberStation to the list");
        List<PhoneAndMedicalWithStation> getFire = new ArrayList<>();
        String getStation = map.entrySet().stream().filter(entry -> entry.getValue().getAddresses().contains(address)).map(Map.Entry::getKey).findFirst().get();
        getFire.add(new PhoneAndMedicalWithStation(getPhoneAndMedicalList, getStation));

        logger.info("Fire info find successfully");
        return getFire;
    }
}
