package com.gestion_clinic.gestion_clinic.services;

import com.gestion_clinic.gestion_clinic.entities.RendezVous;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public interface RendezVousService {
    Collection<RendezVous> getAll();
    Optional<RendezVous> getById(Long id);
    RendezVous save (RendezVous rendezVous);
   RendezVous Update (RendezVous rendezVous);
    void deleById (Long id);
}
