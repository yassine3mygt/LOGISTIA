package com.example.logistics_service.service;

import com.example.logistics_service.dto.ExpeditionRequest;
import com.example.logistics_service.dto.ExpeditionResponse;
import com.example.logistics_service.entity.Conteneur;
import com.example.logistics_service.entity.Expedition;
import com.example.logistics_service.entity.StatutExp;
import com.example.logistics_service.repository.ConteneurRepository;
import com.example.logistics_service.repository.ExpeditionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpeditionService {

    private final ExpeditionRepository expeditionRepository;
    private final ConteneurRepository conteneurRepository;

    public ExpeditionService(ExpeditionRepository expeditionRepository,
                             ConteneurRepository conteneurRepository) {
        this.expeditionRepository = expeditionRepository;
        this.conteneurRepository = conteneurRepository;
    }

    // Create expedition (Créer une expédition)
    public ExpeditionResponse create(ExpeditionRequest request) {

        Conteneur conteneur = conteneurRepository
                .findById(request.getConteneurId())
                .orElseThrow(() ->
                        new RuntimeException("Conteneur not found"));

        Expedition expedition = new Expedition();
        expedition.setReference(request.getReference());
        expedition.setOrigine(request.getOrigine());
        expedition.setDestination(request.getDestination());
        expedition.setDateDepart(request.getDateDepart());
        expedition.setEtaPrevue(request.getEtaPrevue());
        expedition.setTransporteurId(request.getTransporteurId());
        expedition.setChauffeurId(request.getChauffeurId());
        expedition.setConteneur(conteneur);
        expedition.setStatut(StatutExp.CREATED);

        expeditionRepository.save(expedition);

        return mapToResponse(expedition);
    }

    // Get all expeditions (Obtenir toutes les expéditions)
    public List<ExpeditionResponse> getAll() {
        return expeditionRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // Get by id (Obtenir par id)
    public ExpeditionResponse getById(Long id) {
        Expedition expedition = expeditionRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Expedition not found"));
        return mapToResponse(expedition);
    }

    // Update statut (Mettre à jour le statut)
    public ExpeditionResponse updateStatut(Long id, StatutExp statut) {
        Expedition expedition = expeditionRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Expedition not found"));
        expedition.setStatut(statut);
        expeditionRepository.save(expedition);
        return mapToResponse(expedition);
    }

    // Map to response (Convertir en réponse)
    private ExpeditionResponse mapToResponse(Expedition expedition) {
        ExpeditionResponse response = new ExpeditionResponse();
        response.setId(expedition.getId());
        response.setReference(expedition.getReference());
        response.setOrigine(expedition.getOrigine());
        response.setDestination(expedition.getDestination());
        response.setDateDepart(expedition.getDateDepart());
        response.setEtaPrevue(expedition.getEtaPrevue());
        response.setStatut(expedition.getStatut());
        response.setTransporteurId(expedition.getTransporteurId());
        response.setChauffeurId(expedition.getChauffeurId());
        return response;
    }
}