package com.safetynetalerts.controller.enpoints;

import com.safetynetalerts.service.endpoints.FireStationCoverageService;
import com.safetynetalerts.dto.FireCoverage;
import lombok.Data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller mapping GET for FireStationCoverageService and FireStationCoverage endpoint
 */
@Data
@RestController
public class FireStationCoverageController {

    @Autowired
    FireStationCoverageService service;

    @GetMapping("/firestation")
    public List<FireCoverage> getFireStationCoverage(@RequestParam String stationNumber) {
        return service.getFireStationCoverage(stationNumber);
    }
}
