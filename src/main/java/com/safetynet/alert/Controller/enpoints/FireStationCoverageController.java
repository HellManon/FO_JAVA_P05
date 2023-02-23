package com.safetynet.alert.Controller.enpoints;

import com.safetynet.alert.dto.FireCoverage;
import com.safetynet.alert.service.endpoints.FireStationCoverageService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
