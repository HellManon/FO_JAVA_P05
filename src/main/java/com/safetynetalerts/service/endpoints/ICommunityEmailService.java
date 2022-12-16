package com.safetynetalerts.service.endpoints;

import java.util.List;

import com.safetynetalerts.dto.EmailWithName;

public interface ICommunityEmailService {
	List<EmailWithName> getCommunityEmail(String city);

}
