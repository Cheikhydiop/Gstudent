package com.wane.data.seeders;

import com.wane.data.entities.Apprenent;
import com.wane.data.entities.PromotionReferentiel;
import com.wane.data.entities.User;
import com.wane.data.repository.ApprenantRepository;
import com.wane.data.repository.PromotionRefRepository;
import com.wane.data.repository.UserRepository;
import com.wane.utils.Generator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SeedApprenant {

    private static final Logger logger = LoggerFactory.getLogger(SeedApprenant.class);

    private final ApprenantRepository apprenantRepository;
    private final PromotionRefRepository promotionReferentielRepository;
    private final UserRepository userRepository;

    public SeedApprenant(ApprenantRepository apprenantRepository,
                         PromotionRefRepository promotionReferentielRepository,
                         UserRepository userRepository) {
        this.apprenantRepository = apprenantRepository;
        this.promotionReferentielRepository = promotionReferentielRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void seed() {
        long existingApprenantCount = apprenantRepository.count();
        logger.info("Existing apprenants count: {}", existingApprenantCount);

        if (existingApprenantCount == 0) {
            List<PromotionReferentiel> promoRefs = promotionReferentielRepository.findAll();
            logger.info("Found {} PromotionReferentiels.", promoRefs.size());

            if (!promoRefs.isEmpty()) {
                PromotionReferentiel promoRef = promoRefs.get(0);
                List<Apprenent> apprenants = new ArrayList<>();

                for (long i = 1L; i <= 5L; i++) {
                    Optional<User> optionalUser = userRepository.findById(i);
                    if (optionalUser.isPresent()) {
                        User user = optionalUser.get();
                        String matricule = Generator.generateMatricule(
                                promoRef.getPromotion().getLibelle(),
                                promoRef.getReferentiel().getLibelle(), i
                        );

                        logger.info("Creating Apprenent with matricule: {}", matricule);

                        Apprenent apprenent = new Apprenent(
                                "Tuteur" + i,
                                "Prenom" + i,
                                "77813355" + i,
                                matricule,
                                "cni" + i + ".pdf",
                                "extrait" + i + ".pdf",
                                "diplome" + i + ".pdf",
                                "casier" + i + ".pdf",
                                "photo" + i + ".png",
                                null,  // EtatApprenent statut
                                null,  // motif
                                promoRef,
                                user
                        );

                        apprenants.add(apprenent);
                    } else {
                        logger.warn("User with ID {} not found. Skipping this apprenant.", i);
                    }
                }

                if (!apprenants.isEmpty()) {
                    try {
                        apprenantRepository.saveAll(apprenants);
                        logger.info("Apprenants seeding completed. {} apprenants added.", apprenants.size());
                    } catch (Exception e) {
                        logger.error("Error while saving apprenants: ", e);
                    }
                } else {
                    logger.warn("No apprenants to save. Seeding completed without adding any.");
                }
            } else {
                logger.warn("No PromotionReferentiel found. Seeding skipped.");
            }
        } else {
            logger.info("Apprenants seeding skipped. {} apprenants already exist in the database.", existingApprenantCount);
        }
    }
}