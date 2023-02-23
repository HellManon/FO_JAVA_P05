package com.safetynet.alert.service.endpoints;

import com.safetynet.alert.dto.PhoneAndMedicalWithStation;

import java.util.List;

public interface IFireService {
	List<PhoneAndMedicalWithStation> getFire(String address);

}
