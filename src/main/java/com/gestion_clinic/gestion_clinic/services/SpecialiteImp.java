package com.gestion_clinic.gestion_clinic.services;

import com.gestion_clinic.gestion_clinic.entities.Specialite;
import com.gestion_clinic.gestion_clinic.repository.SpecialiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class SpecialiteImp implements SpecialiteService {
    @Autowired
    private SpecialiteRepository specialiteRepository;
    @Override

    public Collection<Specialite> getAll() {
        return specialiteRepository.findAll();

    }

    @Override
    public Optional<Specialite> getById(Long id) {
        return specialiteRepository.findById(id);

    }

    @Override
    public Specialite save(Specialite specialite) {
        return specialiteRepository.save(specialite);

    }

    @Override
    public Specialite Update(Specialite specialite) {
        return specialiteRepository.save(specialite);

    }

    @Override
    public void deleById(Long id) {

            specialiteRepository.deleteById(id);

    }



}
