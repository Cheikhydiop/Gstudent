package com.wane.data.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "apprenants")
public class Apprenent  extends  AbstractEntity{


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


}