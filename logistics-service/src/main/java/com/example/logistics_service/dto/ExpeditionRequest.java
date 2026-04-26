package com.example.logistics_service.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ExpeditionRequest {
    private String reference;
    private String origine;
    private String destination;
    private LocalDateTime dateDepart;
    private LocalDateTime etaPrevue;
    private Long transporteurId;
    private Long chauffeurId;
    private Long conteneurId;
}