package com.safetynet.alerts.Utility;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.service.PersonAge;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class getPersonAgeTests {

    @Autowired
    PersonAge personAge = new PersonAge();

    @Test
    public void getPersonAgeTest() {
        String birthdate = "03/09/1984";
        int age = personAge.getPersonAge(birthdate);
        int expectedAge = 38;
        assertThat(age).isEqualTo(expectedAge);
    }
}
