package com.example.logistics_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "inventaires")
@Data
public class Inventaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emplacement;

    private LocalDateTime dateEntree;

    @OneToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;
}