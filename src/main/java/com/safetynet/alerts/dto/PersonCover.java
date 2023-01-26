package com.safetynet.alerts.dto;

import lombok.Data;

@Data
public class PersonCover {
	private String firstName;
	private String lastName;
	private String address;
	private String phone;

	public PersonCover(String firstName, String lastName, String address, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
	}

	public PersonCover() {
	}

}
