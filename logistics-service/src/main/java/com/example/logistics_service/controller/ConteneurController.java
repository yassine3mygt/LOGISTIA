package com.example.logistics_service.controller;

import com.example.logistics_service.dto.ConteneurRequest;
import com.example.logistics_service.entity.Conteneur;
import com.example.logistics_service.repository.ConteneurRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/conteneurs")
public class ConteneurController {

    private final ConteneurRepository conteneurRepository;

    public ConteneurController(ConteneurRepository conteneurRepository) {
        this.conteneurRepository = conteneurRepository;
    }

    // Create conteneur
    @PostMapping
    public ResponseEntity<Conteneur> create(
            @RequestBody ConteneurRequest request) {
        Conteneur conteneur = new Conteneur();
        conteneur.setNumero(request.getNumero());
        conteneur.setType(request.getType());
        return ResponseEntity.ok(conteneurRepository.save(conteneur));
    }

    @GetMapping
    public ResponseEntity<List<Conteneur>> getAll() {
        return ResponseEntity.ok(conteneurRepository.findAll());
    }
}