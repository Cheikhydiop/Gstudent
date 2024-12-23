package com.wane.web.dto.response;
import com.wane.data.entities.EtatApprenent;

public record ApprenentResponseDto(
        Long id,
        String nomTuteur,
        String prenomTuteur,
        String contactTuteur,
        String matricule,
        String cniFile,
        String extraitFile,
        String diplomeFile,
        String casierFile,
        String photoCouverture,
        EtatApprenent statut,
        String motif,
        Long promotionReferentielId,
        Long userId
) {}
