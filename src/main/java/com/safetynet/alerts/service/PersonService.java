package com.safetynet.alerts.service;

import com.safetynet.alerts.dao.JSONReader;
import com.safetynet.alerts.dao.Reader;
import com.safetynet.alerts.model.Person;
import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Service that allows to get a person's list from jsonfile, to add, delete and update this list.
 */
@Data
@Service
public class PersonService implements IPersonService {

    @Autowired
    private JSONReader jsonReader;

    private List<Person> list;

    public PersonService(Reader jsonReader) throws IOException {
        this.list = jsonReader.readPerson();
    }

    public List<Person> getPersons() {
        return list;
    }

    public Result deletePerson(String firstName, String lastName) {
        for (Person person : list) {
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
                list.remove(person);
                return Result.success;
            }
        }
        return Result.failure;
    }

    public Person savePerson(Person person) {
        list.add(new Person(person.getFirstName(), person.getLastName(), person.getAddress(), person.getCity(), person.getZip(), person.getPhone(), person.getEmail()));
        return person;
    }

    public Result updatePerson(Person person, String firstName, String lastName) {
        for (Person person1 : list) {
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
                int index = list.indexOf(person1);
                list.set(index, person);
                return Result.success;
            }
        }
        return Result.failure;
    }
}
