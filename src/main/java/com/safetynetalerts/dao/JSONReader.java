package com.safetynetalerts.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import com.safetynetalerts.model.Firestations;
import com.safetynetalerts.model.Medicalrecords;
import com.safetynetalerts.model.Person;


public class JSONReader implements Reader { 
	
	String input = "src/main/resources/data.json";
	byte[] bytesFile = Files.readAllBytes(new File(input).toPath());
	JsonIterator iter = JsonIterator.parse(bytesFile);
	Any any = iter.readAny();
	
	public JSONReader() throws IOException {
		
	}
	

	public List<Person> readPerson() {
		Any personAny = any.get("persons");
		List<Person> persons = new ArrayList<>();
		for (Any person : personAny) {
			persons.add(new Person(person.get("firstname").toString(), person.get("lastname").toString(), person.get("address").toString(), person.get("city").toString(), person.get("zip").toString(),person.get("phone").toString(), person.get("email").toString()));
		}
		return persons;
	}


	public List<Medicalrecords> readMedicalRecord() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}


	public Map<String, Firestations> readFireStation() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
