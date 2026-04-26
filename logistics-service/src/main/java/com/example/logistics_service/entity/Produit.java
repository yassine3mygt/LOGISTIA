package com.example.logistics_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "produits")
@Data
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String designation;

    private Integer quantite;

    private Double poidsUnitaire;

    @ManyToOne
    @JoinColumn(name = "conteneur_id")
    private Conteneur conteneur;

    @OneToOne(mappedBy = "produit")
    private Inventaire inventaire;
}