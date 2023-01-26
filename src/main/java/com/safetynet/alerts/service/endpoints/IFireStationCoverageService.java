package com.safetynet.alerts.service.endpoints;

import java.text.ParseException;
import java.util.List;

import com.safetynet.alerts.dto.FireCoverage;

public interface IFireStationCoverageService {
	List<FireCoverage> getFireStationCoverage(String station) throws ParseException;

}
