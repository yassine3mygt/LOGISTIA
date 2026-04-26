package com.example.logistics_service.dto;

import com.example.logistics_service.entity.StatutExp;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ExpeditionResponse {
    private Long id;
    private String reference;
    private String origine;
    private String destination;
    private LocalDateTime dateDepart;
    private LocalDateTime etaPrevue;
    private StatutExp statut;
    private Long transporteurId;
    private Long chauffeurId;
}