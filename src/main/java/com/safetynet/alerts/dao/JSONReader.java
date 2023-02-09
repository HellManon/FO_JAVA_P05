package com.safetynet.alerts.dao;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;

import lombok.Data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
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
			persons.add(new Person(person.get("firstName").toString(), person.get("lastName").toString(), person.get("address").toString(), person.get("city").toString(),
					person.get("zip").toString(), person.get("phone").toString(), person.get("email").toString()));
		}
		return persons;
	}

	public List<MedicalRecord> readMedicalRecord() {
		Any medicalAny = any.get("medicalrecords");
		List<MedicalRecord> medicalRecords = new ArrayList<>();
		medicalAny.forEach(medical -> medicalRecords.add(new MedicalRecord(medical.get("firstName").toString(), medical.get("lastName").toString(),
				medical.get("birthdate").toString(), medical.get("medications").toString(), medical.get("allergies").toString())));
		return medicalRecords;
	}

	public Map<String, FireStation> readFireStation() {
		Any fireStationAny = any.get("firestations");
		Map<String, FireStation> fireStations = new HashMap<>();
		fireStationAny.forEach(station -> fireStations.compute(station.get("station").toString(),
				(k, v) -> v == null ?
						new FireStation(station.get("station").toString()).addAddress(station.get("address").toString()) :
						v.addAddress(station.get("address").toString())));
		return fireStations;
	}

}

