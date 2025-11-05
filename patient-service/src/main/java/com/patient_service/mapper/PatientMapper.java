package com.patient_service.mapper;
import com.patient_service.dto.PatientRequestDto;
import com.patient_service.dto.PatientResponseDto;
import com.patient_service.model.Patient;

import java.time.LocalDate;

public class PatientMapper {

    public static PatientResponseDto toDto(Patient patient){
        PatientResponseDto patientResponseDto = new PatientResponseDto();
        patientResponseDto.setID(patient.getId().toString());
        patientResponseDto.setAddress(patient.getAddress());
        patientResponseDto.setEmail(patient.getEmail());
        patientResponseDto.setName(patient.getName());
        patientResponseDto.setDateOfBirth(patient.getDateOfBirth().toString());

        return patientResponseDto;
    }

    public static Patient toModel(PatientRequestDto patientRequestDto){
        Patient patient = new Patient();
        patient.setName(patientRequestDto.getName());
        patient.setEmail(patientRequestDto.getEmail());
        patient.setAddress(patientRequestDto.getAddress());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDto.getDateOfBrith()));
        patient.setDateOfRegistration(LocalDate.parse(patientRequestDto.getDateOfRegistration()));

        return patient;
    }
}
