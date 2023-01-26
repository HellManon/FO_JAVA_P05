package com.safetynet.alerts.service.Endpoints;


import com.safetynet.alerts.dao.JSONReader;
import com.safetynet.alerts.dao.Reader;
import com.safetynet.alerts.dto.PhoneWithName;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.service.endpoints.IPhoneAlertService;
import com.safetynet.alerts.service.endpoints.PhoneAlertService;

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

public class PhoneAlertServiceTests {
    private IPhoneAlertService service;
    private FireStation fireStation;

    private Reader reader;

    @BeforeEach
    public void setUp() throws IOException {
        fireStation = new FireStation();
        reader = Mockito.mock(JSONReader.class);
        List<Person> listPerson = new ArrayList<>();
        listPerson.add(new Person("John", "Wayne", "1 rue Pournousdeux", "Paris", "75000", "010203", "jwayneparis@mail.com"));
        Map<String, FireStation> map = new HashMap<>();
        map.put("1", fireStation.addAddress("1 rue Pournousdeux"));
        when(reader.readPerson()).thenReturn(listPerson);
        when(reader.readFireStation()).thenReturn(map);
        service = new PhoneAlertService(reader);
    }

    @Test
    public void getPhoneAlertTest() {
        List<PhoneWithName> expectedList = new ArrayList<>();
        expectedList.add(new PhoneWithName("John", "Wayne","010203"));
        List<PhoneWithName> getPhoneAlert = service.getPhoneAlert("1");
        assertEquals(expectedList,getPhoneAlert);
    }
}