package com.safetynet.alerts.dto;

import lombok.Data;

@Data
public class Adult {
	private String firstName;
	private String lastName;

	public Adult(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Adult() {
	}

}
