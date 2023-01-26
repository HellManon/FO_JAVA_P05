package com.safetynet.alerts.service.endpoints;

import java.util.List;

import com.safetynet.alerts.dto.PhoneWithName;

public interface IPhoneAlertService {
	List<PhoneWithName> getPhoneAlert(String station);

}
