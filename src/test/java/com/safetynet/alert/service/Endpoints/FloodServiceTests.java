package com.safetynet.alert.service.Endpoints;

import com.safetynet.alert.dao.JSONReader;
import com.safetynet.alert.dao.Reader;
import com.safetynet.alert.dto.PhoneAndMedical;
import com.safetynet.alert.dto.PhoneAndMedicalByAddress;
import com.safetynet.alert.dto.StationAndAddress;
import com.safetynet.alert.model.FireStation;
import com.safetynet.alert.model.MedicalRecord;
import com.safetynet.alert.model.Person;
import com.safetynet.alert.service.endpoints.FloodService;
import com.safetynet.alert.service.endpoints.IFloodService;
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


public class FloodServiceTests {
    private IFloodService service;
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
        service = new FloodService(reader);
    }

    @Test
    public void getFloodServiceTest() {
        List<StationAndAddress> expectedList = new ArrayList<>();
        List<PhoneAndMedical> phoneAndMedicals = new ArrayList<>();
        phoneAndMedicals.add(new PhoneAndMedical("John", "Wayne", "010203", "32","[\"paracetamol 1000mg\"]", "[\"penicillin\"]"));
        List<PhoneAndMedicalByAddress> phoneAndMedicalByAddresses = new ArrayList<>();
        phoneAndMedicalByAddresses.add(new PhoneAndMedicalByAddress("1 rue Pournousdeux", phoneAndMedicals));
        expectedList.add(new StationAndAddress("1",phoneAndMedicalByAddresses));
        List<String> stations = new ArrayList<>();
        stations.add("1");
        List<StationAndAddress> getFlood = service.getFlood(stations);
        assertEquals(expectedList,getFlood);
    }
}