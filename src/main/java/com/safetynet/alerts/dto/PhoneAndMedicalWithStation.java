package com.safetynet.alerts.dto;

import java.util.List;

import lombok.Data;

@Data
public class PhoneAndMedicalWithStation {
	private List<PhoneAndMedical> phoneAndMedicalList;
	private String station;

	public PhoneAndMedicalWithStation(List<PhoneAndMedical> phoneAndMedicalList, String station) {
		this.phoneAndMedicalList = phoneAndMedicalList;
		this.station = station;
	}

}
