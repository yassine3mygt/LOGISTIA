package com.example.billing_service.repository;

import com.example.billing_service.entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {

    // Pour récupérer les factures d'une entreprise spécifique (SaaS Multi-tenant)
    List<Facture> findByEntrepriseId(Long entrepriseId);

    // Pour trouver la facture liée à une expédition précise
    List<Facture> findByExpeditionId(Long expeditionId);
}