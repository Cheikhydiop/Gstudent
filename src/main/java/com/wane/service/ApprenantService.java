package com.wane.service;

import com.wane.data.entities.Apprenent;
import com.wane.data.entities.User;
import com.wane.data.entities.EtatApprenent;
import com.wane.data.repository.ApprenantRepository;
import com.wane.web.dto.request.CreateApprenantRequest;
import com.wane.web.mapper.ApprenantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class ApprenantService {

    @Autowired
    private ApprenantRepository apprenantRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ApprenantMapper apprenantMapper;

    @Autowired
    private EmailService emailService;

    /**
     * Récupère tous les apprenants.
     *
     * @return une liste de tous les apprenants
     */
    public List<Apprenent> listAllApprenents() {
        return apprenantRepository.findAll();
    }

    /**
     * Récupère les apprenants par leur statut.
     *
     * @param statut le statut des apprenants à récupérer
     * @return une liste d'apprenants avec le statut spécifié
     */
    public List<Apprenent> findApprenentsByStatut(EtatApprenent statut) {
        return apprenantRepository.findByStatut(statut);
    }

    /**
     * Crée un nouvel apprenant.
     *
     * @param request les informations de l'apprenant à ajouter
     * @return l'apprenant ajouté
     */
    public Apprenent saveApprenant(CreateApprenantRequest request) {
        try {
            // Mapping request to entity
            Apprenent apprenant = apprenantMapper.toEntity(request);

            apprenant.setMatricule(generateMatricule());
            String defaultPassword = "defaultPassword";

            User user = userService.createUserApprenant(request);
            user.setPassword(defaultPassword);
            apprenant.setUser(user);

            Apprenent savedApprenant = apprenantRepository.save(apprenant);

            emailService.sendAuthLink(user);

            return savedApprenant;
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de la création de l'apprenant ou de l'envoi de l'email", e);
        }
    }

    /**
     * Mettre à jour un apprenant existant.
     *
     * @param apprenant l'apprenant à mettre à jour
     * @return l'apprenant mis à jour
     */
    public Apprenent updateApprenent(Apprenent apprenant) {
        return apprenantRepository.save(apprenant);
    }

    /**
     * Supprimer un apprenant par son ID.
     *
     * @param id l'ID de l'apprenant à supprimer
     */
    public void deleteApprenent(Long id) {
        apprenantRepository.deleteById(id);
    }

    private String generateMatricule() {
        return "MAT" + System.currentTimeMillis();
    }

    private String generateQRCode(Apprenent apprenant) {
        return "QRCodeData";
    }
}