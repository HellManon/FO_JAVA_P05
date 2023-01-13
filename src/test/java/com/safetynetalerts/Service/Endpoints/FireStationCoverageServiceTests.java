package com.safetynetalerts.Service.Endpoints;

import com.safetynetalerts.dao.JSONReader;
import com.safetynetalerts.dao.Reader;
import com.safetynetalerts.dto.FireCoverage;
import com.safetynetalerts.dto.PersonCover;
import com.safetynetalerts.model.FireStation;
import com.safetynetalerts.model.MedicalRecord;
import com.safetynetalerts.model.Person;
import com.safetynetalerts.service.endpoints.FireStationCoverageService;
import com.safetynetalerts.service.endpoints.IFireStationCoverageService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FireStationCoverageServiceTests {
    private IFireStationCoverageService service;
    private Person person;
    private FireStation fireStation;
    private MedicalRecord medicalRecord;

    private Reader reader;

    @BeforeEach
    public void setUp() throws IOException {
        person = new Person();
        fireStation = new FireStation();
        medicalRecord = new MedicalRecord();
        reader = Mockito.mock(JSONReader.class);
        List<Person> listPerson = new ArrayList<>();
        listPerson.add(new Person("John", "Wayne", "1 rue Pournousdeux", "Paris", "75000", "010203", "jwayneparis@mail.com"));
        Map<String, FireStation> map = new HashMap<>();
        map.put("1", fireStation.addAddress("1 rue Pournousdeux"));
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        medicalRecordList.add(new MedicalRecord("John", "Wayne", "01/01/1991", "[\"paracetamol 1000mg\"]", "[\"penicillin\"]"));
        when(reader.readPerson()).thenReturn(listPerson);
        when(reader.readFireStation()).thenReturn(map);
        when(reader.readMedicalRecord()).thenReturn(medicalRecordList);
        service = new FireStationCoverageService(reader);
    }

    @Test
    public void getFireStationCoverageTest() throws ParseException {
        List<PersonCover> personCoverList = new ArrayList<>();
        personCoverList.add(new PersonCover("John", "Wayne", "1 rue Pournousdeux", "010203"));
        List<FireCoverage> expectedList = new ArrayList<>();
        expectedList.add(new FireCoverage(personCoverList,1,0));
        List<FireCoverage> getFireStationCoverage = service.getFireStationCoverage("1");
        assertEquals(expectedList,getFireStationCoverage);
    }
}
