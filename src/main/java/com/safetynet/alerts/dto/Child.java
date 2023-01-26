package com.safetynet.alerts.dto;

import lombok.Data;

@Data
public class Child {
    private String firstName;
    private String lastName;
    private int age;

    public Child(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Child() {
    }

   
}
