package com.safetynet.alerts.service.endpoints;

import java.util.List;

import com.safetynet.alerts.dto.PersonInfo;

public interface IPersonInfoService {
	List<PersonInfo> getPersonInfo(String firstName, String lastName);

}
