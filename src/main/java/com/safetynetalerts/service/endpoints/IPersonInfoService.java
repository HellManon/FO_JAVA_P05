package com.safetynetalerts.service.endpoints;

import java.util.List;

import com.safetynetalerts.dto.PersonInfo;

public interface IPersonInfoService {
	List<PersonInfo> getPersonInfo(String firstName, String lastName);

}
