package com.example.auth_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "entreprises")
@Data

public class Entreprise {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String identifiantFiscal;

    private String adresse;

    @OneToMany(mappedBy = "entreprise")
    private List<User> users;

}
