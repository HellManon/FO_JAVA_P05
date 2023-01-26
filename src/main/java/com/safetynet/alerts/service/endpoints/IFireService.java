package com.safetynet.alerts.service.endpoints;

import java.util.List;

import com.safetynet.alerts.dto.PhoneAndMedicalWithStation;

public interface IFireService {
	List<PhoneAndMedicalWithStation> getFire(String address);

}
