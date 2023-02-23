package com.safetynet.alert.service.endpoints;

import com.safetynet.alert.dto.FireCoverage;

import java.text.ParseException;
import java.util.List;

public interface IFireStationCoverageService {
	List<FireCoverage> getFireStationCoverage(String station) throws ParseException;

}
