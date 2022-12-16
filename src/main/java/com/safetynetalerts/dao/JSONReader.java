package com.safetynetalerts.dao;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import com.safetynetalerts.model.FireStation;
import com.safetynetalerts.model.MedicalRecord;
import com.safetynetalerts.model.Person;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JSONReader implements Reader {

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(JSONReader.class);
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


	public List<MedicalRecord> readMedicalRecord() throws IOException {
		Any medicalAny = any.get("medicalrecords");
		List<MedicalRecord> medicalRecords = new ArrayList<>();
		for (Any medicalrecord : medicalAny)
			medicalRecords.add(new MedicalRecord(medicalrecord.get("firstname").toString(), medicalrecord.get("lastname").toString(), medicalrecord.get("birthdate").toString(), medicalrecord.get("birthdate").toString(), medicalrecord.get("medications").toString(), medicalrecord.get("allergies").toString()));
		return medicalRecords;
	}


	public Map<String, FireStation> readFireStation() throws IOException {
		Any firestationAny = any.get("firestations");
		Map<String, FireStation> fireStations = new HashMap<>();
		firestationAny.forEach(station -> fireStations.compute(station.get("station").toString(), (k, v) -> v == null ? new FireStation(station.get("station").toString()).addAddress(station.get("address").toString()) : v.addAddress(station.get("address").toString())));
        return fireStations;
	}

}
