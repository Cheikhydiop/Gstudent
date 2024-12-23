package com.wane.data.repository;

import com.wane.data.entities.Apprenent;
import com.wane.data.entities.EtatApprenent;

import java.util.Date;
import java.util.List;

public interface ApprenantRepository  extends  ParentRepository<Apprenent, Long> {
    List<Apprenent> findByStatut(EtatApprenent status);
    // Retourne les apprenants qui ont été marqués comme supprimés
//    List<Apprenent> findAllDelete(EtatApprenent status);

    // Retourne tous les apprenants, y compris ceux qui ont été supprimés
//    List<Apprenent> findAll(EtatApprenent status);
//
    // Méthode pour supprimer un apprenant en utilisant un soft delete
//    default void softDelete(Apprenent apprenant) {
//        apprenant.setDateSuppression(new Date());
//        save(apprenant); // Sauvegarde l'apprenant avec la date de suppression
//    }
}