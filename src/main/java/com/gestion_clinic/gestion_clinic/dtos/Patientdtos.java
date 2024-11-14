package com.gestion_clinic.gestion_clinic.dtos;

import lombok.Data;

@Data
public class Patientdtos {
    private Long id;
    private String nom;
    private String prenom;
    private String tel;
    private String sexe;
    private String nationalite;

}
