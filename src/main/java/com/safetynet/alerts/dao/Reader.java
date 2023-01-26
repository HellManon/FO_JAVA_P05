package com.safetynet.alerts.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;

public interface Reader {
	List<Person> readPerson() throws IOException;
	
	List<MedicalRecord> readMedicalRecord() throws IOException;
	
	Map<String, FireStation> readFireStation() throws IOException;
}
