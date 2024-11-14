package com.gestion_clinic.gestion_clinic.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String tel;
    private String sexe;
    private String nationalite;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Specialite")
    private Specialite specialite;


}
