package com.safetynetalerts.controller;

import com.safetynetalerts.service.FireStationService;
import com.safetynetalerts.service.Result;
import com.safetynetalerts.model.FireStation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Controller mapping CRUD for FireStationService
 */
@Data
@RestController
public class FireStationController {

    @Autowired
    private FireStationService service;

    @GetMapping("/firestations")
    public Map<String, FireStation> getFireStation() {
        return service.getFireStation();
    }

    @DeleteMapping("/firestation/deleteAddress/{address}")
    public Result deleteAddressOfFireStation(@PathVariable("address") String address) {
        return service.deleteAddressOfFireStation(address);
    }

    @DeleteMapping("/firestation/deleteStation/{station}")
    public Result deleteFireStation(@PathVariable("station") String station) {
        return service.deleteFireStation(station);
    }

    @PostMapping("/firestation")
    public FireStation saveFireStation(@RequestBody FireStation fireStation) {
        return service.saveFireStation(fireStation);
    }

    @PutMapping("/firestation/{station}/{address}")
    public Result updateFireStationOfAddress(@PathVariable("station") String station, @PathVariable("address") String address, @RequestBody FireStation fireStation) {
        return service.updateFireStationOfAddress(fireStation, station, address);
    }
}