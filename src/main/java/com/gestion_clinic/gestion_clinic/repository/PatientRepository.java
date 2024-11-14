package com.gestion_clinic.gestion_clinic.repository;

import com.gestion_clinic.gestion_clinic.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
