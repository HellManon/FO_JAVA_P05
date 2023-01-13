package com.safetynetalerts.dao;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import com.safetynetalerts.model.FireStation;
import com.safetynetalerts.model.MedicalRecord;
import com.safetynetalerts.model.Person;

import lombok.Data;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Component
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


	public List<MedicalRecord> readMedicalRecord() throws IOException {
		Any medicalAny = any.get("medicalrecords");
		List<MedicalRecord> medicalRecords = new ArrayList<>();
		for (Any medical : medicalAny)
			medicalRecords.add(new MedicalRecord(medical.get("firstName").toString(), medical.get("lastName").toString(), medical.get("birthDate").toString(), medical.get("birthdate").toString(), medical.get("medications").toString()));
		return medicalRecords;
	}


	public Map<String, FireStation> readFireStation() throws IOException {
		Any firestationAny = any.get("firestations");
		Map<String, FireStation> fireStations = new HashMap<>();
		firestationAny.forEach(station -> fireStations.compute(station.get("station").toString(), (k, v) -> v == null ? new FireStation(station.get("station").toString()).addAddress(station.get("address").toString()) : v.addAddress(station.get("address").toString())));
        return fireStations;
	}

}
