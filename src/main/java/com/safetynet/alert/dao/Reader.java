package com.safetynet.alert.dao;

import com.safetynet.alert.model.FireStation;
import com.safetynet.alert.model.MedicalRecord;
import com.safetynet.alert.model.Person;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface Reader {
	List<Person> readPerson() throws IOException;
	
	List<MedicalRecord> readMedicalRecord() throws IOException;
	
	Map<String, FireStation> readFireStation() throws IOException;
}
