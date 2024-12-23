package com.wane.data.seeders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DbSeeder.class);
    private final SeedApprenant seedApprenant;

    public DbSeeder(SeedApprenant seedApprenant) {
        this.seedApprenant = seedApprenant;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            logger.info("Démarrage du peuplement des données.");
            seedApprenant.seed(); // Appel à la méthode de peuplement
            logger.info("Peuplement des données terminé avec succès.");
        } catch (Exception e) {
            logger.error("Erreur lors du peuplement des données : ", e);
        }
    }
}