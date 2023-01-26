package com.safetynet.alerts.dto;

import lombok.Data;

@Data
public class EmailWithName {
	private String firstName;
	private String lastName;
	private String email;

	public EmailWithName(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public EmailWithName() {
	}
}
