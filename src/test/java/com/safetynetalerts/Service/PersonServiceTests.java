package com.safetynetalerts.Service;

import com.safetynetalerts.dao.JSONReader;
import com.safetynetalerts.dao.Reader;
import com.safetynetalerts.model.Person;
import com.safetynetalerts.service.IPersonService;
import com.safetynetalerts.service.PersonService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;


public class PersonServiceTests {
    private IPersonService service;
    private Person person;


    private Reader reader;

    @BeforeEach
    public void setUp() throws IOException {
        person = new Person();
        reader = Mockito.mock(JSONReader.class);
        List<Person> expectedList = new ArrayList<>();
        expectedList.add(new Person("John", "Wayne", "1 rue Pournousdeux", "Paris", "75000", "010203", "jwayneparis@mail.com"));
        expectedList.add(new Person("Sam", "Daten", "12 rue du canapé", "Paris", "75000", "040506", "sdatenparis@mail.com"));
        when(reader.readPerson()).thenReturn(expectedList);
        service = new PersonService(reader);

    }

    @Test
    public void getPersonTest() {
        List<Person> getPerson = service.getPersons();
        assertNotNull(getPerson);
    }

    @Test
    public void deletePersonTest() {
        service.deletePerson("John", "Wayne");
        assertNull(person.getFirstName(), person.getLastName());
    }

    @Test
    public void savePersonTest() {
        Person person = new Person("Bob", "Dylan", "10 rue Heaven's door", "Heaven", "00000", "010101", "bdylanheaven@mail.com");
        Person personSaved = service.savePerson(person);
        assertNotNull(personSaved);
    }

    @Test
    public void updatePersonTest() {
        Person person = new Person("John", "Wayne", "1 rue Pournousdeux", "Paris", "75000", "030201", "jwayneparis@mail.com");
        service.updatePerson(person, "John", "Wayne");
        assertEquals("030201", person.getPhone());
    }
}
