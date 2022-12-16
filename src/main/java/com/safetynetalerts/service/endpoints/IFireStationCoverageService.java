package com.safetynetalerts.service.endpoints;

import java.text.ParseException;
import java.util.List;

import com.safetynetalerts.dto.FireCoverage;

public interface IFireStationCoverageService {
	List<FireCoverage> getFireStationCoverage(String station) throws ParseException;

}
