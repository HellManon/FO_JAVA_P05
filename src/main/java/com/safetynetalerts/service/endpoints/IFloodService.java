package com.safetynetalerts.service.endpoints;

import java.util.List;

import com.safetynetalerts.dto.StationAndAddress;

public interface IFloodService {
	 List<StationAndAddress> getFlood (List<String> stations);

}
