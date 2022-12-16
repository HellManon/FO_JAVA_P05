package com.safetynetalerts.service.endpoints;

import java.util.List;

import com.safetynetalerts.dto.PhoneAndMedicalWithStation;

public interface IFireService {
	List<PhoneAndMedicalWithStation> getFire(String address);

}
