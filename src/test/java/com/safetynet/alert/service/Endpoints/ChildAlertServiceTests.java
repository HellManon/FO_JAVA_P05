package com.safetynet.alert.service.Endpoints;

import com.safetynet.alert.dao.JSONReader;
import com.safetynet.alert.dao.Reader;
import com.safetynet.alert.dto.Adult;
import com.safetynet.alert.dto.Child;
import com.safetynet.alert.dto.ChildrenAndAdults;
import com.safetynet.alert.model.MedicalRecord;
import com.safetynet.alert.model.Person;
import com.safetynet.alert.service.endpoints.ChildAlertService;
import com.safetynet.alert.service.endpoints.IChildAlertService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ChildAlertServiceTests {
    private IChildAlertService service;
    private Person person;
    private MedicalRecord medicalRecord;

    private Reader reader;

    @BeforeEach
    public void setUp() throws IOException {
        person = new Person();
        medicalRecord = new MedicalRecord();
        reader = Mockito.mock(JSONReader.class);
        List<Person> listPerson = new ArrayList<>();
        listPerson.add(new Person("John", "Wayne", "1 rue Pournousdeux", "Paris", "75000", "010203", "jwayneparis@mail.com"));
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        medicalRecordList.add(new MedicalRecord("John", "Wayne", "01/01/2010", "[\"paracetamol 1000mg\"]", "[\"penicillin\"]"));
        when(reader.readPerson()).thenReturn(listPerson);
        when(reader.readMedicalRecord()).thenReturn(medicalRecordList);
        service = new ChildAlertService(reader);
    }

    @Test
    public void getChildAlertTest() throws Exception {
        List<Child> childList = new ArrayList<>();
        childList.add(new Child("John", "Wayne", 13));
        List<Adult> adults = new ArrayList<>();
        List<ChildrenAndAdults> expectedList = new ArrayList<>();
        expectedList.add(new ChildrenAndAdults(childList,adults));
        List<ChildrenAndAdults> getChildAlert = service.getChildAlert("1 rue Pournousdeux");
        assertEquals(expectedList,getChildAlert);
    }
}