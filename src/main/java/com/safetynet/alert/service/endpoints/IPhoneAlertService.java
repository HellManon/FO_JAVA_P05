package com.safetynet.alert.service.endpoints;

import com.safetynet.alert.dto.PhoneWithName;

import java.util.List;

public interface IPhoneAlertService {
	List<PhoneWithName> getPhoneAlert(String station);

}
