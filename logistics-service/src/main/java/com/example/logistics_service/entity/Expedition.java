package com.example.logistics_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "expeditions")
@Data
public class Expedition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reference;

    private String origine;

    private String destination;

    private LocalDateTime dateDepart;

    private LocalDateTime etaPrevue;

    @Enumerated(EnumType.STRING)
    private StatutExp statut;

    private Long transporteurId;

    private Long chauffeurId;

    @ManyToOne
    @JoinColumn(name = "conteneur_id")
    private Conteneur conteneur;
}