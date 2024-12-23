package com.wane.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "apprenants")
public class Apprenent extends AbstractEntity {

    private String nomTuteur;
    private String prenomTuteur;
    private String contactTuteur;

    @Column(unique = true)
    private String matricule;

    private String cniFile;
    private String extraitFile;
    private String diplomeFile;
    private String casierFile;
    private String photoCouverture;

    @Enumerated(EnumType.STRING)
    private EtatApprenent statut = null;

    private String motif;

    @ManyToOne
    @JoinColumn(name = "promo_ref_id")
    private PromotionReferentiel promotionReferentiel;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Ajout d'un constructeur correspondant aux paramètres utilisés dans SeedApprenant
    public Apprenent(String nomTuteur, String prenomTuteur, String contactTuteur, String matricule,
                     String cniFile, String extraitFile, String diplomeFile,
                     String casierFile, String photoCouverture, EtatApprenent statut,
                     String motif, PromotionReferentiel promotionReferentiel, User user) {
        this.nomTuteur = nomTuteur;
        this.prenomTuteur = prenomTuteur;
        this.contactTuteur = contactTuteur;
        this.matricule = matricule;
        this.cniFile = cniFile;
        this.extraitFile = extraitFile;
        this.diplomeFile = diplomeFile;
        this.casierFile = casierFile;
        this.photoCouverture = photoCouverture;
        this.statut = statut;
        this.motif = motif;
        this.promotionReferentiel = promotionReferentiel;
        this.user = user;
    }
}
