package com.safetynet.alert.service.endpoints;

import com.safetynet.alert.dto.PersonInfo;

import java.util.List;

public interface IPersonInfoService {
	List<PersonInfo> getPersonInfo(String firstName, String lastName);

}
