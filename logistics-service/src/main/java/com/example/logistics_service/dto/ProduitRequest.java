package com.example.logistics_service.dto;

import lombok.Data;

@Data
public class ProduitRequest {
    private String designation;
    private Integer quantite;
    private Double poidsUnitaire;
    private Long conteneurId;
}