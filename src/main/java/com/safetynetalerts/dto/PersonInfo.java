package com.safetynetalerts.dto;

import lombok.Data;

@Data
public class PersonInfo {
	private String firstName;
    private String lastName;
    private String address;
    private String age;
    private String email;
    private String medications;
    private String allergies;

    public PersonInfo(String firstName, String lastName, String address, String age, String email, String medications, String allergies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
        this.email = email;
        this.medications = medications;
        this.allergies = allergies;
    }

    public PersonInfo() {}

}
