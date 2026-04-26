package com.example.logistics_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "conteneurs")
@Data
public class Conteneur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    private String type;

    @OneToMany(mappedBy = "conteneur")
    private List<Produit> produits;
}