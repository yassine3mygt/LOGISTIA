package com.example.logistics_service.controller;

import com.example.logistics_service.dto.ProduitRequest;
import com.example.logistics_service.entity.Produit;
import com.example.logistics_service.service.ProduitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    // Create produit
    @PostMapping
    public ResponseEntity<Produit> create(
            @RequestBody ProduitRequest request) {
        return ResponseEntity.ok(produitService.create(request));
    }

    // Get all produits
    @GetMapping
    public ResponseEntity<List<Produit>> getAll() {
        return ResponseEntity.ok(produitService.getAll());
    }
}