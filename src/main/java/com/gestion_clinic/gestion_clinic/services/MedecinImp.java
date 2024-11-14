package com.gestion_clinic.gestion_clinic.services;

import com.gestion_clinic.gestion_clinic.entities.Medecin;
import com.gestion_clinic.gestion_clinic.entities.Patient;
import com.gestion_clinic.gestion_clinic.repository.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class MedecinImp implements  MedecinService{

@Autowired
private MedecinRepository medecinRepository;
    @Override
    public Collection<Medecin> getAll() {
        return medecinRepository.findAll();

    }

    @Override
    public Optional<Medecin> getById(Long id) {
        return medecinRepository.findById(id);


    }

    @Override
    public Medecin save(Medecin medecin) {
        return medecinRepository.save(medecin);

    }

    @Override
    public Medecin Update(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public void deleById(Long id) {
        medecinRepository.deleteById(id);

    }
}
