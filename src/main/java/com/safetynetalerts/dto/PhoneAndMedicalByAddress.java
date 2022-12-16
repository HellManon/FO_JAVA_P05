package com.safetynetalerts.dto;

import java.util.List;

import lombok.Data;

@Data
public class PhoneAndMedicalByAddress {
	private String address;
	private List<PhoneAndMedical> phoneAndMedicalList;

	public PhoneAndMedicalByAddress() {
	}

	public PhoneAndMedicalByAddress(String address, List<PhoneAndMedical> phoneAndMedicalList) {
		this.address = address;
		this.phoneAndMedicalList = phoneAndMedicalList;
	}

}
