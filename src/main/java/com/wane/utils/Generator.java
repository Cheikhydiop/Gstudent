package com.wane.utils;


public class Generator {

    public static String generateMatricule(String promotionLibelle, String referentielLibelle, long index) {
        // Utilisez un format pour générer le matricule
        return String.format("%s-%s-%03d", promotionLibelle, referentielLibelle, index);
    }
}
