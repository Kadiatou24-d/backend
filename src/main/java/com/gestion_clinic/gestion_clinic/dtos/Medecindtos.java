package com.gestion_clinic.gestion_clinic.dtos;

import com.gestion_clinic.gestion_clinic.entities.Specialite;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class Medecindtos {
    private Long id;
    private String nom;
    private String prenom;
    private String tel;
    private String sexe;
    private String nationalite;
    @ManyToOne

    private Specialite specialite ;
}
