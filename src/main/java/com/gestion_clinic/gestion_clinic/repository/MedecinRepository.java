package com.gestion_clinic.gestion_clinic.repository;

import com.gestion_clinic.gestion_clinic.entities.Medecin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
}
