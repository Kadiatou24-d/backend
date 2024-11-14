package com.gestion_clinic.gestion_clinic.services;

import com.gestion_clinic.gestion_clinic.entities.Patient;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public interface PatientService {
    Collection<Patient> getAll();
    Optional <Patient> getById(Long id);
    Patient save (Patient patient);
    Patient Update (Patient patient);
    void deleById (Long id);
}
