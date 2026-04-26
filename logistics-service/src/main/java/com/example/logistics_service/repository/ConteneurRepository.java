package com.example.logistics_service.repository;

import com.example.logistics_service.entity.Conteneur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConteneurRepository
        extends JpaRepository<Conteneur, Long> {
}