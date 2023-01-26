package com.safetynet.alerts.service;

import java.util.List;
import com.safetynet.alerts.model.MedicalRecord;

import com.safetynet.alerts.service.Result;

public interface IMedicalRecordService {
    List<MedicalRecord> getMedicalRecords();

    Result deleteMedicalRecord(String firstName, String lastName);

    MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord);

    Result updateMedicalRecord(MedicalRecord medicalRecord, String firstName, String lastName);

}
