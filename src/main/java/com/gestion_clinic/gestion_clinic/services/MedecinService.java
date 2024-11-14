package com.gestion_clinic.gestion_clinic.services;

import com.gestion_clinic.gestion_clinic.entities.Medecin;
import com.gestion_clinic.gestion_clinic.entities.Patient;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public interface MedecinService {
    Collection<Medecin> getAll();
    Optional <Medecin> getById(Long id);
    Medecin save (Medecin medecin);
    Medecin Update (Medecin medecin);
    void deleById (Long id);



}
