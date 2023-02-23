package com.safetynet.alert.service;

import com.safetynet.alert.dao.JSONReader;
import com.safetynet.alert.dao.Reader;
import com.safetynet.alert.model.MedicalRecord;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Service that allows to get a Medical Record's list from jsonfile, to add, delete and update this list.
 */
@Data
@Service
public class MedicalRecordService implements IMedicalRecordService {
    
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
