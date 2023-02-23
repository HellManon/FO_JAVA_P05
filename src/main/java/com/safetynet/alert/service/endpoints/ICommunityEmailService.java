package com.safetynet.alert.service.endpoints;

import com.safetynet.alert.dto.EmailWithName;

import java.util.List;

public interface ICommunityEmailService {
	List<EmailWithName> getCommunityEmail(String city);

}
