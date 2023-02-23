package com.safetynet.alert.service.endpoints;


import com.safetynet.alert.dao.JSONReader;
import com.safetynet.alert.dao.Reader;
import com.safetynet.alert.dto.PersonInfo;
import com.safetynet.alert.model.MedicalRecord;
import com.safetynet.alert.model.Person;
import com.safetynet.alert.service.PersonAge;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service that allows to get a person's list with their name, address,age, email and medical's info, from list of specified firstName and lastName.
 */
@Data
@Service
public class PersonInfoService implements IPersonInfoService {
    private static final Logger logger = LogManager.getLogger("PersonInfoService");

    @Autowired
    JSONReader jsonReader;

    PersonAge personAge = new PersonAge();

    private List<Person> listPerson;
    private List<MedicalRecord> listMedical;

    public PersonInfoService(Reader jsonReader) throws IOException {
        this.listPerson = jsonReader.readPerson();
        this.listMedical = jsonReader.readMedicalRecord();
    }

    public List<PersonInfo> getPersonInfo(String firstName, String lastName) {
        logger.debug("Entering getPersonInfo");
        List<PersonInfo> personInfos = listPerson.stream().filter(person -> person.getFirstName().contains(firstName) && person.getLastName().contains(lastName))
                .flatMap(person -> listMedical.stream()
                        .filter(medicalRecord -> medicalRecord.getFirstName().contains(firstName) && medicalRecord.getLastName().contains(lastName))
                        .map(personAndMedical ->
                        {
                            PersonInfo personInfo = new PersonInfo();
                            personInfo.setFirstName(personAndMedical.getFirstName());
                            personInfo.setLastName(personAndMedical.getLastName());
                            personInfo.setAddress(person.getAddress());
                            personInfo.setAge(String.valueOf(personAge.getPersonAge(personAndMedical.getBirthDate())));
                            personInfo.setEmail(person.getEmail());
                            personInfo.setMedications(personAndMedical.getMedications());
                            personInfo.setAllergies(personAndMedical.getAllergies());
                            return personInfo;
                        })).collect(Collectors.toList());
        logger.info("Person Info find successfully");
        return personInfos;
    }
}

