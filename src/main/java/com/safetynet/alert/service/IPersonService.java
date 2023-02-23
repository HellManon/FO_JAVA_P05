package com.safetynet.alert.service;

import com.safetynet.alert.model.Person;

import java.util.List;

public interface IPersonService {
	List<Person> getPersons();

    Result deletePerson(String firstName, String lastName);

    Person savePerson(Person person);

    Result updatePerson(Person person, String firstName, String lastName);

}
