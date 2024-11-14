package com.gestion_clinic.gestion_clinic.services;

import com.gestion_clinic.gestion_clinic.entities.RendezVous;
import com.gestion_clinic.gestion_clinic.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class RendezVousImp implements RendezVousService {

    @Autowired
    private RendezVousRepository rendezVousRepository;

    @Override
    public Collection<RendezVous> getAll() {
        return rendezVousRepository.findAll();

    }

    @Override
    public Optional<RendezVous> getById(Long id) {
        return rendezVousRepository.findById(id);
    }

    @Override
    public RendezVous save(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public RendezVous Update(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public void deleById(Long id) {

rendezVousRepository.deleteById(id);
    }
}


