package com.example.billing_service.dto;

import lombok.Data;

@Data
public class FactureRequest {
    private Double montantHT;
    private Double tva;
    private Long expeditionId;
    private Long entrepriseId;
}