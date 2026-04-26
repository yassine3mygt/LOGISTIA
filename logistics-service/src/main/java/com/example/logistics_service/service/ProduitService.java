package com.example.logistics_service.service;

import com.example.logistics_service.dto.ProduitRequest;
import com.example.logistics_service.entity.Conteneur;
import com.example.logistics_service.entity.Produit;
import com.example.logistics_service.repository.ConteneurRepository;
import com.example.logistics_service.repository.ProduitRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;
    private final ConteneurRepository conteneurRepository;

    public ProduitService(ProduitRepository produitRepository,
                          ConteneurRepository conteneurRepository) {
        this.produitRepository = produitRepository;
        this.conteneurRepository = conteneurRepository;
    }

    // Create produit (Créer un produit)
    public Produit create(ProduitRequest request) {

        Conteneur conteneur = conteneurRepository
                .findById(request.getConteneurId())
                .orElseThrow(() ->
                        new RuntimeException("Conteneur not found"));

        Produit produit = new Produit();
        produit.setDesignation(request.getDesignation());
        produit.setQuantite(request.getQuantite());
        produit.setPoidsUnitaire(request.getPoidsUnitaire());
        produit.setConteneur(conteneur);

        return produitRepository.save(produit);
    }

    // Get all produits (Obtenir tous les produits)
    public List<Produit> getAll() {
        return produitRepository.findAll();
    }
}