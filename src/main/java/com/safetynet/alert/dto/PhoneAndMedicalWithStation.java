package com.safetynet.alert.dto;

import lombok.Data;

import java.util.List;

@Data
public class PhoneAndMedicalWithStation {
	private List<PhoneAndMedical> phoneAndMedicalList;
	private String station;

	public PhoneAndMedicalWithStation(List<PhoneAndMedical> phoneAndMedicalList, String station) {
		this.phoneAndMedicalList = phoneAndMedicalList;
		this.station = station;
	}

}
