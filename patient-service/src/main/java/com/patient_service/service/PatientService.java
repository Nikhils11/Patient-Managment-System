package com.patient_service.service;
import com.patient_service.dto.PatientRequestDto;
import com.patient_service.dto.PatientResponseDto;
import com.patient_service.exception.EmailAlreadyExistsException;
import com.patient_service.exception.PatientNotFoundException;
import com.patient_service.mapper.PatientMapper;
import com.patient_service.model.Patient;
import com.patient_service.repository.PatientRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Service
public class PatientService {

    private final PatientRepo patientRepo;

    public PatientService(PatientRepo patientRepo){
        this.patientRepo = patientRepo;
    }

    public List<PatientResponseDto> getPatients(){
        List<Patient> patientList = patientRepo.findAll();

        List<PatientResponseDto> patientResponseDtos = patientList.stream()
                .map(patient -> PatientMapper.toDto(patient))
                .toList();

        return patientResponseDtos;
    }

    public PatientResponseDto createPatient(PatientRequestDto patientRequestDto){
        Patient patient = PatientMapper.toModel(patientRequestDto);
        if(patientRepo.existsByEmail(patient.getEmail())){
            throw new EmailAlreadyExistsException("A patient already exists for this email"
                    +patient.getEmail());
        }
        try{
            this.patientRepo.save(patient);
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
        PatientResponseDto patientResponseDto = PatientMapper.toDto(patient);
        return patientResponseDto;
    }

    public PatientResponseDto updatePatient(UUID Id, PatientRequestDto patientRequestDto){
        Patient patient = patientRepo.findById(Id).orElseThrow(
                () -> new PatientNotFoundException("Patient not found with this ID: "+ Id));
        patient.setName(patientRequestDto.getName());
        patient.setAddress(patientRequestDto.getAddress());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDto.getDateOfBrith()));
        patient.setEmail(patientRequestDto.getEmail());
        return PatientMapper.toDto(patient);
    }
}
