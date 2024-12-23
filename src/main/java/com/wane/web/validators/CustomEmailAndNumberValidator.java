package com.wane.web.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import com.wane.web.dto.request.CreateApprenantRequest;

public class CustomEmailAndNumberValidator implements ConstraintValidator<ValidEmailAndNumber, CreateApprenantRequest> {

    @Override
    public boolean isValid(CreateApprenantRequest request, ConstraintValidatorContext context) {
        if (request == null) {
            return true;
        }

        String email = request.getEmail();
        String contactTuteur = request.getContactTuteur();
        Long promotionReferentielId = request.getPromotionReferentielId();

        // Logique de validation personnalisée ici
        // Par exemple, vérifiez si l'email est valide et si le numéro de contact correspond à un modèle spécifique
        // Et peut-être valider promotionReferentielId

        return email != null && !email.isEmpty()
                && contactTuteur != null && !contactTuteur.isEmpty();
    }
}