package com.patient_service.repository;
import com.patient_service.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;


@Repository
public interface PatientRepo extends JpaRepository<Patient, UUID> {
    boolean existsByEmail(String email);
}
