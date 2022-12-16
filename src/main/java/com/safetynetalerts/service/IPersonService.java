package com.safetynetalerts.service;

import java.util.List;

import com.safetynetalerts.model.Person;

public interface IPersonService {
	List<Person> getPersons();

    Result deletePerson(String firstName, String lastName);

    Person savePerson(Person person);

    Result updatePerson(Person person, String firstName, String lastName);

}
