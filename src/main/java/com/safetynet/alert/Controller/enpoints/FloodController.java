package com.safetynet.alert.Controller.enpoints;

import com.safetynet.alert.dto.StationAndAddress;
import com.safetynet.alert.service.endpoints.FloodService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller mapping GET for FloodService and Flood endpoint
 */
@Data
@RestController
public class FloodController {

    @Autowired
    FloodService floodService;

    @GetMapping("/flood/stations")
    public List<StationAndAddress> getFlood(@RequestParam List<String> stations) {
        return floodService.getFlood(stations);
    }
}