package com.safetynet.alerts.service.Endpoints;

import com.safetynet.alerts.service.endpoints.FireService;
import com.safetynet.alerts.service.endpoints.IFireService;
import com.safetynet.alerts.dao.JSONReader;
import com.safetynet.alerts.dao.Reader;
import com.safetynet.alerts.dto.PhoneAndMedical;
import com.safetynet.alerts.dto.PhoneAndMedicalWithStation;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FireServiceTests {
    private IFireService service;
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
        service = new FireService(reader);
    }

    @Test
    public void getFireServiceTest() {
        List<PhoneAndMedical> phoneAndMedicals = new ArrayList<>();
        phoneAndMedicals.add(new PhoneAndMedical("John", "Wayne", "010203", "32", "[\"paracetamol 1000mg\"]", "[\"penicillin\"]" ));
        List<PhoneAndMedicalWithStation> expectedList = new ArrayList<>();
        expectedList.add(new PhoneAndMedicalWithStation(phoneAndMedicals,"1"));
        List<PhoneAndMedicalWithStation> getFire = service.getFire("1 rue Pournousdeux");
        assertEquals(expectedList,getFire);
    }
}