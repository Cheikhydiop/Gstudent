package com.wane.web.controller;

import com.wane.web.dto.request.CreateApprenantRequest;
import com.wane.data.entities.Apprenent;
import com.wane.data.entities.EtatApprenent;
import com.wane.service.ApprenantService;
import com.wane.web.dto.response.ApprenantResponse;
import com.wane.web.dto.response.ApprenentResponseDto;
import com.wane.web.mapper.ApprenantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/apprenents")
public class ApprenantController implements IApprenantController {

    @Autowired
    private ApprenantService apprenantService;

    @Autowired
    private ApprenantMapper apprenantMapper;

    @GetMapping
    public List<Apprenent> listAllApprenents() {
        return apprenantService.listAllApprenents();
    }

    @GetMapping("/status/{statut}")
    public List<Apprenent> listApprenentsByStatut(@PathVariable("statut") EtatApprenent statut) {
        return apprenantService.findApprenentsByStatut(statut);
    }

    @PostMapping
    public ApprenantResponse createApprenant(@Valid @RequestBody CreateApprenantRequest request) {
        // Création de l'apprenant
        Apprenent savedApprenant = apprenantService.saveApprenant(request);

        // La méthode saveApprenant gère maintenant la conversion entre requête et entité ainsi que la sauvegarde

        // Conversion de l'entité apprenante sauvegardée vers la réponse DTO
        return apprenantMapper.toResponse(savedApprenant);
    }

   
}