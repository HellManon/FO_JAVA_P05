package com.safetynetalerts.service.endpoints;

import com.safetynetalerts.dao.JSONReader;
import com.safetynetalerts.dao.Reader;
import com.safetynetalerts.dto.Adult;
import com.safetynetalerts.dto.Child;
import com.safetynetalerts.dto.ChildrenAndAdults;
import com.safetynetalerts.model.MedicalRecord;
import com.safetynetalerts.model.Person;
import com.safetynetalerts.service.PersonAge;

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
 * Service that allows to get a child's list with adults linked, who lived in specified address.
 */
@Data
@Service
public class ChildAlertService implements IChildAlertService {
    private static Logger logger = LogManager.getLogger("ChildAlertService");

    @Autowired
    JSONReader jsonReader;

    PersonAge personAge = new PersonAge();

    private List<Person> listPerson;
    private List<MedicalRecord> listMedical;

    public ChildAlertService(Reader jsonReader) throws IOException {
        this.listPerson = jsonReader.readPerson();
        this.listMedical = jsonReader.readMedicalRecord();
    }

    public List<ChildrenAndAdults> getChildAlert(String address) {
        logger.debug("Entering getChildAlert");
        Map<Boolean, List<MedicalRecord>> booleanListMap = listPerson.stream().filter(person -> person.getAddress().contains(address))
                .flatMap(medicalrecord -> listMedical.stream()
                        .filter(person -> person.getFirstName().contains(medicalrecord.getFirstName()) && person.getLastName().contains(medicalrecord.getLastName())))
                .collect(Collectors.partitioningBy(person -> personAge.getPersonAge(person.getBirthDate()) <= 18));
        logger.debug("Create ChildrenList");
        List<Child> childList = booleanListMap.get(true).stream().map(child ->
        {
            Child child1 = new Child();
            child1.setFirstName(child.getFirstName());
            child1.setLastName(child.getLastName());
            child1.setAge(personAge.getPersonAge(child.getBirthDate()));
            return child1;
        }).collect(Collectors.toList());
        logger.debug("Create AdultsList");
        List<Adult> adultList = booleanListMap.get(false).stream().map(adult ->
        {
            Adult adult1 = new Adult();
            adult1.setFirstName(adult.getFirstName());
            adult1.setLastName(adult.getLastName());
            return adult1;
        }).collect(Collectors.toList());
        logger.debug("Success create List");
        List<ChildrenAndAdults> getChildAlert = new ArrayList<>();
        getChildAlert.add(new ChildrenAndAdults(childList, adultList));

        logger.info("Children and Adults find successfully");
        return getChildAlert;
    }
}



