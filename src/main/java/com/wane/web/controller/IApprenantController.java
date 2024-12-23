package com.wane.web.controller;

import com.wane.data.entities.Apprenent;
import com.wane.data.entities.EtatApprenent;
import com.wane.web.dto.request.CreateApprenantRequest;
import com.wane.web.dto.response.ApprenantResponse;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

public interface IApprenantController {

    @GetMapping
    List<Apprenent> listAllApprenents();

    @GetMapping("/status/{statut}")
    List<Apprenent> listApprenentsByStatut(@PathVariable("statut") EtatApprenent statut);

    @PostMapping
    ApprenantResponse createApprenant(@Valid @RequestBody CreateApprenantRequest request);
}