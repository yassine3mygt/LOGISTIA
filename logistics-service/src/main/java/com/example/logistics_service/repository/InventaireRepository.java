package com.example.logistics_service.repository;

import com.example.logistics_service.entity.Inventaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventaireRepository
        extends JpaRepository<Inventaire, Long> {
}