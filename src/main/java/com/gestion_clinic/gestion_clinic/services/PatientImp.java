package com.gestion_clinic.gestion_clinic.services;

import com.gestion_clinic.gestion_clinic.entities.Patient;
import com.gestion_clinic.gestion_clinic.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class PatientImp implements PatientService {

@Autowired
private PatientRepository patientRepository;

    @Override
    public Collection<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> getById(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient Update(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deleById(Long id) {
patientRepository.deleteById(id);
    }
}
