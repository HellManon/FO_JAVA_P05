package com.safetynet.alerts.service;

import com.safetynet.alerts.dao.JSONReader;
import com.safetynet.alerts.dao.Reader;
import com.safetynet.alerts.model.FireStation;

import com.safetynet.alerts.service.FireStationService;
import com.safetynet.alerts.service.IFireStationService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class FireStationServiceTests {
    private IFireStationService service;
    private FireStation fireStation;

    private Reader reader;

    @BeforeEach
    public void setUp() throws IOException {
        fireStation = new FireStation();
        reader = Mockito.mock(JSONReader.class);
        Map<String, FireStation> map = new HashMap<>();
        fireStation.setStation("1");
        fireStation.addAddress("1 rue Pournousdeux");
        map.put("1", fireStation);
        when(reader.readFireStation()).thenReturn(map);
        service = new FireStationService(reader);
    }

    @Test
    public void getFireStationTest() {
        Map<String, FireStation> getFireStation = service.getFireStation();
        assertNotNull(getFireStation);
    }

    @Test
    public void deleteAddressOfFireStationTest() {
        assertEquals(Result.success, service.deleteAddressOfFireStation("1 rue Pournousdeux"));
    }

    @Test
    public void deleteFireStationTest() {
        assertEquals(Result.success, service.deleteFireStation("1"));
    }

    @Test
    public void saveFireStationTest() {
        FireStation fireStation = new FireStation();
        fireStation.setStation("1");
        fireStation.setAddress("1 rue Pournousdeux");
        FireStation fireStationSaved = service.saveFireStation(fireStation);
        assertNotNull(fireStationSaved);
    }

    @Test
    public void updateFireStationTest() {
        FireStation fireStation = new FireStation();
        fireStation.setStation("1");
        fireStation.setAddress("2 rue Pournousdeux");
        service.updateFireStationOfAddress(fireStation,"1", "1 rue Pournousdeux");
        assertEquals("2 rue Pournousdeux", fireStation.getAddress());
    }
}
