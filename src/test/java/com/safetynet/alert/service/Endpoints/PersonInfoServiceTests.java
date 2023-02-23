package com.safetynet.alert.service.Endpoints;

import com.safetynet.alert.dao.JSONReader;
import com.safetynet.alert.dao.Reader;
import com.safetynet.alert.dto.PersonInfo;
import com.safetynet.alert.model.MedicalRecord;
import com.safetynet.alert.model.Person;
import com.safetynet.alert.service.endpoints.IPersonInfoService;
import com.safetynet.alert.service.endpoints.PersonInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PersonInfoServiceTests {
    private IPersonInfoService service;
    private Reader reader;

    @BeforeEach
    public void setUp() throws IOException {
        new Person();
        new MedicalRecord();
        reader = Mockito.mock(JSONReader.class);
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("John", "Wayne", "1 rue Pournousdeux", "Paris", "75000", "010203", "jwayneparis@mail.com"));
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        medicalRecordList.add(new MedicalRecord("John", "Wayne", "01/01/1991", "[\"paracetamol 1000mg\"]", "[\"penicillin\"]"));
        when(reader.readPerson()).thenReturn(personList);
        when(reader.readMedicalRecord()).thenReturn(medicalRecordList);
        service = new PersonInfoService(reader);
    }

    @Test
    public void getPersonInfoTest() {
        List<PersonInfo> expectedList = new ArrayList<>();
        expectedList.add(new PersonInfo("John", "Wayne", "1 rue Pournousdeux", "32", "jwayneparis@mail.com", "[\"paracetamol 1000mg\"]","[\"penicillin\"]"));
        List<PersonInfo> getPersonInfo = service.getPersonInfo("John", "Wayne");
        assertEquals(expectedList,getPersonInfo);
    }
}
