package com.safetynetalerts.service;

import com.safetynetalerts.dao.JSONReader;
import com.safetynetalerts.dao.Reader;
import com.safetynetalerts.model.MedicalRecord;

import java.util.List;

import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Service that allows to get a Medical Record's list from jsonfile, to add, delete and update this list.
 */
@Data
@Service
public class MedicalRecordService implements IMedicalRecordService {
    private static Logger logger = LogManager.getLogger("MedicalRecordService");

    @Autowired
    JSONReader jsonReader;

    private List<MedicalRecord> list;

    public MedicalRecordService(Reader jsonReader) throws IOException {
        this.list = jsonReader.readMedicalRecord();
    }

    public List<MedicalRecord> getMedicalRecords() {
        return list;
    }

    public Result deleteMedicalRecord(String firstName, String lastName) {
        for (MedicalRecord medicalRecord : list) {
            if (medicalRecord.getFirstName().equals(firstName) && medicalRecord.getLastName().equals(lastName)) {
                list.remove(medicalRecord);
                return Result.success;
            }
        }
        return Result.failure;
    }

    public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {
        list.add(new MedicalRecord(medicalRecord.getFirstName(), medicalRecord.getLastName(), medicalRecord.getBirthDate(), medicalRecord.getMedications(), medicalRecord.getAllergies()));
        return medicalRecord;
    }

    public Result updateMedicalRecord(MedicalRecord medicalRecord, String firstName, String lastName) {
        for (MedicalRecord medicalRecord1 : list) {
            if (medicalRecord.getFirstName().equals(firstName) && medicalRecord.getLastName().equals(lastName)) {
                int index = list.indexOf(medicalRecord1);
                list.set(index, medicalRecord);
                return Result.success;
            }
        }
        return Result.failure;
    }
}
