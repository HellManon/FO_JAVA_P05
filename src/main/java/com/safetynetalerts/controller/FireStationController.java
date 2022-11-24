package com.safetynetalerts.controller;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.FireStationDao;

@RestController
public class FireStationController {
		
	
	}
	
	//@GetMapping("/firestation?stationNumber=<station_number>")
	@GetMapping("/firestation")
	public MappingJacksonValue stationNumber (){
		
		
		return "station number";
	}
	
	//@GetMapping("/phoneAlert?firestation=<firestation_number>")
	@GetMapping("/firestation_number")
	public String firestationNumber (){
		return "firestation number";
	}
	
	@GetMapping("/flood/stations?stations=<a list of station_numbers>")
	public String ListOfStationNumber (){
		return "List of station number ";
	}
	
}