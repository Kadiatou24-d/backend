package com.gestion_clinic.gestion_clinic.services;


import com.gestion_clinic.gestion_clinic.entities.Specialite;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public interface SpecialiteService {
    Collection<Specialite> getAll();
    Optional<Specialite> getById(Long id);
    Specialite save (Specialite specialite);
    Specialite Update (Specialite specialite);
    void deleById (Long id);
}
