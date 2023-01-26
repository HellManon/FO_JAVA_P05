package com.safetynet.alerts.controller.enpoints;

import com.safetynet.alerts.service.endpoints.ChildAlertService;
import com.safetynet.alerts.dto.ChildrenAndAdults;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller mapping GET for ChildAlertService and ChildAlert endpoint
 */
@Data
@RestController
public class ChildAlertController {

    @Autowired
    ChildAlertService service;

    @GetMapping("/childAlert")
    public List<ChildrenAndAdults> getChildAlert(@RequestParam String address) {
        return service.getChildAlert(address);
    }
}
