package com.safetynetalerts.Service.Endpoints;

import com.safetynetalerts.dao.JSONReader;
import com.safetynetalerts.dao.Reader;
import com.safetynetalerts.dto.EmailWithName;
import com.safetynetalerts.model.Person;
import com.safetynetalerts.service.endpoints.CommunityEmailService;
import com.safetynetalerts.service.endpoints.ICommunityEmailService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CommunityEmailServiceTests {
    private ICommunityEmailService service;
    private Reader reader;

    @BeforeEach
    public void setUp() throws IOException {
        new Person();
        reader = Mockito.mock(JSONReader.class);
        List<Person> listPerson = new ArrayList<>();
        listPerson.add(new Person("John", "Wayne", "1 rue Pournousdeux", "Paris", "75000", "010203", "jwayneparis@mail.com"));
        when(reader.readPerson()).thenReturn(listPerson);
        service = new CommunityEmailService(reader);
    }

    @Test
    public void getCommunityEmailTest() {
        List<EmailWithName> expectedList = new ArrayList<>();
        expectedList.add(new EmailWithName("John", "Wayne", "jwayneparis@mail.com"));
        List<EmailWithName> getCommunityEmail = service.getCommunityEmail("Paris");
        assertEquals(expectedList,getCommunityEmail);
    }

}