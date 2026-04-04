package com.example.auth_service.repository;

import com.example.auth_service.entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository
        extends JpaRepository<Entreprise, Long> {
}