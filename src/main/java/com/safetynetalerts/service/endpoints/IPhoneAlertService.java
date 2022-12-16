package com.safetynetalerts.service.endpoints;

import java.util.List;

import com.safetynetalerts.dto.PhoneWithName;

public interface IPhoneAlertService {
	List<PhoneWithName> getPhoneAlert(String station);

}
