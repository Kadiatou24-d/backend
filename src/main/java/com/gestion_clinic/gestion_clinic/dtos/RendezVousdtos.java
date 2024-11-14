package com.gestion_clinic.gestion_clinic.dtos;

import com.gestion_clinic.gestion_clinic.entities.Medecin;
import com.gestion_clinic.gestion_clinic.entities.Patient;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class RendezVousdtos {

    private Long id;
    private String nom;
    private String prenom;
    private String tel;
    private String sexe;
    private String nationalite;
    private String adresse;
    @ManyToOne
    private Patient patient ;
    @ManyToOne
    private Medecin medecin;
}
