package com.safetynetalerts.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.safetynetalerts.model.Firestations;
import com.safetynetalerts.model.Medicalrecords;
import com.safetynetalerts.model.Person;

public interface Reader {
	List<Person> readPerson() throws IOException;
	
	List<Medicalrecords> readMedicalRecord() throws IOException;
	
	Map<String, Firestations> readFireStation() throws IOException;
}
