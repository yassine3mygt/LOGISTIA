package com.example.logistics_service.repository;

import com.example.logistics_service.entity.Expedition;
import com.example.logistics_service.entity.StatutExp;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExpeditionRepository
        extends JpaRepository<Expedition, Long> {

    List<Expedition> findByStatut(StatutExp statut);

    List<Expedition> findByTransporteurId(Long transporteurId);

    List<Expedition> findByChauffeurId(Long chauffeurId);
}