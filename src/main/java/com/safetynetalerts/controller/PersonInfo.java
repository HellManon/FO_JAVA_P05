package com.safetynetalerts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonInfo {
	@GetMapping("/communityEmail?city=<city>")
	public String communityEmail (){
		return "communityEmail";
	}
	
	@GetMapping("/personInfo?firstName=<firstName>&lastName=<lastName>")
	public String personInfo (){
		return "personInfo";
	}
	
	@GetMapping("/childAlert?address=<address>")
	public String childAlert (){
		return "childAlert";
	}
	
	@GetMapping("/fire?address=<address>")
	public String adress (){
		return "adress";
	}
	
}
