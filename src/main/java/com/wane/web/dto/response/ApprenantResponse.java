package com.wane.web.dto.response;


import com.wane.data.entities.EtatApprenent;

public class ApprenantResponse {

    private Long id;
    private String nomTuteur;
    private String prenomTuteur;
    private String contactTuteur;
    private String matricule;
    private String cniFile;
    private String extraitFile;
    private String diplomeFile;
    private String casierFile;
    private String photoCouverture;
    private EtatApprenent statut;
    private String motif;
    private Long promotionReferentielId;
    private Long userId;

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomTuteur() {
        return nomTuteur;
    }

    public void setNomTuteur(String nomTuteur) {
        this.nomTuteur = nomTuteur;
    }

    public String getPrenomTuteur() {
        return prenomTuteur;
    }

    public void setPrenomTuteur(String prenomTuteur) {
        this.prenomTuteur = prenomTuteur;
    }

    public String getContactTuteur() {
        return contactTuteur;
    }

    public void setContactTuteur(String contactTuteur) {
        this.contactTuteur = contactTuteur;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getCniFile() {
        return cniFile;
    }

    public void setCniFile(String cniFile) {
        this.cniFile = cniFile;
    }

    public String getExtraitFile() {
        return extraitFile;
    }

    public void setExtraitFile(String extraitFile) {
        this.extraitFile = extraitFile;
    }

    public String getDiplomeFile() {
        return diplomeFile;
    }

    public void setDiplomeFile(String diplomeFile) {
        this.diplomeFile = diplomeFile;
    }

    public String getCasierFile() {
        return casierFile;
    }

    public void setCasierFile(String casierFile) {
        this.casierFile = casierFile;
    }

    public String getPhotoCouverture() {
        return photoCouverture;
    }

    public void setPhotoCouverture(String photoCouverture) {
        this.photoCouverture = photoCouverture;
    }

    public EtatApprenent getStatut() {
        return statut;
    }

    public void setStatut(EtatApprenent statut) {
        this.statut = statut;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Long getPromotionReferentielId() {
        return promotionReferentielId;
    }

    public void setPromotionReferentielId(Long promotionReferentielId) {
        this.promotionReferentielId = promotionReferentielId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}