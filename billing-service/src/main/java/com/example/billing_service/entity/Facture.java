package com.example.billing_service.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "factures")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String reference; // Ex: FACT-2026-001

    private Double montantHT;
    private Double tva;
    private Double montantTTC;

    private LocalDateTime dateEmission;
    private Boolean estPayee;

    // Références logiques aux autres micro-services (Clés étrangères distantes)
    private Long expeditionId;
    private Long entrepriseId;
}