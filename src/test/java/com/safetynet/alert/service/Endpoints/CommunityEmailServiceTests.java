package com.safetynet.alert.service.Endpoints;

import com.safetynet.alert.dao.JSONReader;
import com.safetynet.alert.dao.Reader;
import com.safetynet.alert.dto.EmailWithName;
import com.safetynet.alert.model.Person;
import com.safetynet.alert.service.endpoints.CommunityEmailService;
import com.safetynet.alert.service.endpoints.ICommunityEmailService;
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