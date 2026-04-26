package com.example.logistics_service.controller;

import com.example.logistics_service.dto.ExpeditionRequest;
import com.example.logistics_service.dto.ExpeditionResponse;
import com.example.logistics_service.entity.StatutExp;
import com.example.logistics_service.service.ExpeditionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/expeditions")
public class ExpeditionController {

    private final ExpeditionService expeditionService;

    public ExpeditionController(ExpeditionService expeditionService) {
        this.expeditionService = expeditionService;
    }

    // Create expedition
    @PostMapping
    public ResponseEntity<ExpeditionResponse> create(
            @RequestBody ExpeditionRequest request) {
        return ResponseEntity.ok(expeditionService.create(request));
    }

    // Get all expeditions
    @GetMapping
    public ResponseEntity<List<ExpeditionResponse>> getAll() {
        return ResponseEntity.ok(expeditionService.getAll());
    }

    // Get by id
    @GetMapping("/{id}")
    public ResponseEntity<ExpeditionResponse> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(expeditionService.getById(id));
    }

    // Update statut
    @PutMapping("/{id}/statut")
    public ResponseEntity<ExpeditionResponse> updateStatut(
            @PathVariable Long id,
            @RequestParam StatutExp statut) {
        return ResponseEntity.ok(
                expeditionService.updateStatut(id, statut));
    }
}