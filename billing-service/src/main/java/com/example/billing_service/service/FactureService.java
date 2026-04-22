package com.example.billing_service.service;

import com.example.billing_service.dto.FactureRequest;
import com.example.billing_service.entity.Facture;
import com.example.billing_service.repository.FactureRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class FactureService {

    private final FactureRepository factureRepository;

    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }

    public Facture creerFacture(FactureRequest request) {
        // Logique de calcul : Montant TTC = HT + (HT * TVA / 100)
        double montantTtc = request.getMontantHT() + (request.getMontantHT() * request.getTva() / 100);

        Facture facture = Facture.builder()
                .reference("FACT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase())
                .montantHT(request.getMontantHT())
                .tva(request.getTva())
                .montantTTC(montantTtc)
                .dateEmission(LocalDateTime.now())
                .estPayee(false)
                .expeditionId(request.getExpeditionId())
                .entrepriseId(request.getEntrepriseId())
                .build();

        return factureRepository.save(facture);
    }

    public List<Facture> getFacturesParEntreprise(Long entrepriseId) {
        return factureRepository.findByEntrepriseId(entrepriseId);
    }
}