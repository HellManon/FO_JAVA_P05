package com.safetynetalerts.service;

import java.util.List;
import com.safetynetalerts.model.MedicalRecord;

public interface IMedicalRecordService {
    List<MedicalRecord> getMedicalRecords();

    Result deleteMedicalRecord(String firstName, String lastName);

    MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord);

    Result updateMedicalRecord(MedicalRecord medicalRecord, String firstName, String lastName);

}
