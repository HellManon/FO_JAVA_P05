package com.safetynetalerts.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.safetynetalerts.model.FireStation;
import com.safetynetalerts.model.MedicalRecord;
import com.safetynetalerts.model.Person;

public interface Reader {
	List<Person> readPerson() throws IOException;
	
	List<MedicalRecord> readMedicalRecord() throws IOException;
	
	Map<String, FireStation> readFireStation() throws IOException;
}
