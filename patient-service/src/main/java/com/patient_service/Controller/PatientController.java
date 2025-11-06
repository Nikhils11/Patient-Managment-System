package com.patient_service.Controller;
import com.patient_service.dto.PatientRequestDto;
import com.patient_service.dto.PatientResponseDto;
import com.patient_service.mapper.PatientMapper;
import com.patient_service.model.Patient;
import com.patient_service.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/patients")
@Tag(name = "Patient Api", description = "Apis for managing patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping
    @Operation(summary = "Get patients")
    public ResponseEntity<List<PatientResponseDto>> getPatients(){
        List<PatientResponseDto> patientResponseDtoList = this.patientService.getPatients();
        return ResponseEntity.ok().body(patientResponseDtoList);
    }

    @PostMapping
    @Operation(summary = "Create patients")
    public ResponseEntity<PatientResponseDto> createPatient(
            @Valid @RequestBody PatientRequestDto patientRequestDto){
        PatientResponseDto patientResponseDto = patientService.createPatient(patientRequestDto);
        return ResponseEntity.ok().body(patientResponseDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "update patients")
    public ResponseEntity<PatientResponseDto> updatePatient(
            @PathVariable UUID id, @Valid @RequestBody PatientRequestDto patientRequestDto){

        PatientResponseDto patientResponseDto = patientService.updatePatient(id, patientRequestDto);
        return ResponseEntity.ok().body(patientResponseDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete patients")
    public ResponseEntity<Void> deletePaitent(@PathVariable UUID id){
        patientService.deletePatient(id);
        return ResponseEntity.accepted().build();
    }

}
