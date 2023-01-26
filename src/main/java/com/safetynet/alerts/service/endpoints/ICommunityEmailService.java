package com.safetynet.alerts.service.endpoints;

import java.util.List;

import com.safetynet.alerts.dto.EmailWithName;

public interface ICommunityEmailService {
	List<EmailWithName> getCommunityEmail(String city);

}
