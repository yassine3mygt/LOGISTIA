package com.example.billing_service.controller;

import com.example.billing_service.dto.FactureRequest;
import com.example.billing_service.entity.Facture;
import com.example.billing_service.service.FactureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/billing")
public class FactureController {

    private final FactureService factureService;

    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }

    @PostMapping("/create")
    public ResponseEntity<Facture> createFacture(@RequestBody FactureRequest request) {
        return ResponseEntity.ok(factureService.creerFacture(request));
    }

    @GetMapping("/entreprise/{id}")
    public ResponseEntity<List<Facture>> getByEntreprise(@PathVariable Long id) {
        return ResponseEntity.ok(factureService.getFacturesParEntreprise(id));
    }
}