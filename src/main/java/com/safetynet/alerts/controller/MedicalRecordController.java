package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.service.Result;

import lombok.Data;
import com.safetynet.alerts.service.MedicalRecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller mapping CRUD for MedicalRecordService
 */
@Data
@RestController
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService service;

    @GetMapping("/medicalrecords")
    public Iterable<MedicalRecord> getMedicalRecords() {
        return service.getMedicalRecords();
    }

    @DeleteMapping("/medicalrecords/{firstName}/{lastName}")
    public Result deleteMedicalRecord(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        return service.deleteMedicalRecord(firstName, lastName);
    }

    @PostMapping("/medicalrecord")
    public MedicalRecord saveMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return service.saveMedicalRecord(medicalRecord);
    }

    @PutMapping("/medicalrecords/{firstName}/{lastName}")
    public Result updateMedicalRecord(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName, @RequestBody MedicalRecord medicalRecord) {
        return service.updateMedicalRecord(medicalRecord, firstName, lastName);
    }
}
