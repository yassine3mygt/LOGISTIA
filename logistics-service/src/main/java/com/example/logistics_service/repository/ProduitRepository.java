package com.example.logistics_service.repository;

import com.example.logistics_service.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository
        extends JpaRepository<Produit, Long> {
}