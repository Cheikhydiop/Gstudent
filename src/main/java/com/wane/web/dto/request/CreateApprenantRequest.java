package com.wane.web.dto.request;
import com.wane.data.entities.EtatApprenent;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CreateApprenantRequest {

        @NotBlank(message = "L'email est obligatoire.")
        @Email(message = "L'email doit être valide.")
        private String email;

        @NotBlank(message = "Le nom du tuteur est obligatoire.")
        private String nomTuteur;

        @NotBlank(message = "Le prénom du tuteur est obligatoire.")
        private String prenomTuteur;

        @NotBlank(message = "Le contact du tuteur est obligatoire.")
        @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Le contact du tuteur doit être un numéro de téléphone valide.")
        private String contactTuteur;

        @NotBlank(message = "Le matricule est obligatoire.")
        private String matricule;

        private String cniFile;
        private String extraitFile;
        private String diplomeFile;
        private String casierFile;
        private String photoCouverture;

        @NotNull(message = "Le statut est obligatoire.")
        private EtatApprenent statut;

        private String motif;

        @NotNull(message = "L'ID de promotion référentiel est obligatoire.")
        private Long promotionReferentielId;

        @NotNull(message = "L'ID de l'utilisateur est obligatoire.")
        private Long userId;

        // Getters et setters
        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
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