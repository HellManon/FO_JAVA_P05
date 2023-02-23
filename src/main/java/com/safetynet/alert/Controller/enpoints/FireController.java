package com.safetynet.alert.Controller.enpoints;

import com.safetynet.alert.dto.PhoneAndMedicalWithStation;
import com.safetynet.alert.service.endpoints.FireService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller mapping GET for FireService and Fire endpoint
 */
@Data
@RestController
public class FireController {

    @Autowired
    FireService service;

    @GetMapping("/fire")
    public List<PhoneAndMedicalWithStation> getFire(@RequestParam String address) {
        return service.getFire(address);
    }
}