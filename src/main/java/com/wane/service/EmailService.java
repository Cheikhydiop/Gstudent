package com.wane.service;

import com.wane.data.entities.User;
import com.wane.data.entities.Apprenent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;

import java.io.IOException;

@Service
@Transactional
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private IQrCodeService qrCodeService;

    public void sendQrCode(Apprenent apprenent, String defaultPassword) throws IOException {
        try {
            // Vérifiez que l'utilisateur existe et que son email est présent
            if (apprenent.getUser() == null || apprenent.getUser().getEmail() == null) {
                throw new RuntimeException("L'adresse e-mail de l'utilisateur est manquante.");
            }

            // Générer le QR code à partir des informations du client
            String qrCodeText = "ID du client : " + apprenent.getId() + "\nNom : " ;
            byte[] qrCodeImage = qrCodeService.generateQRCode(qrCodeText);

            // Créer le message MIME
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            // Configurer l'email
            helper.setTo(apprenent.getUser().getEmail());
            helper.setSubject("Votre carte de fidélité avec QR code et informations d'authentification");
            helper.setText("Bonjour " + apprenent.getMatricule() + ",\n\n" +
                    "Merci pour votre inscription. Veuillez trouver ci-joint votre carte de fidélité avec un QR code.\n\n" +
                    "Voici vos informations d'authentification :\n" +
                    "Login (Email) : " + apprenent.getUser().getEmail() + "\n" +
                    "Mot de passe : " + defaultPassword + "\n\n" +
                    "Veuillez changer votre mot de passe après votre première connexion.");

            // Joindre le QR code en tant qu'image
            ByteArrayResource qrCodeAttachment = new ByteArrayResource(qrCodeImage);
            helper.addAttachment("carte_fidelite_qr_code.png", qrCodeAttachment);

            // Envoyer l'e-mail
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Échec de l'envoi de l'e-mail", e);
        }
    }

    public void sendAuthLink(User user) throws IOException {
        try {
            // Générer le QR code avec les informations d'authentification
            String authLink = "http://localhost:8080/login"; // Remplacez par le lien réel de votre application
            String qrCodeText = authLink;
            byte[] qrCodeImage = qrCodeService.generateQRCode(qrCodeText);

            // Créer le message MIME
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            // Configurer l'email
            helper.setTo(user.getEmail());
            helper.setSubject("Votre lien d'authentification");
            helper.setText("Bonjour " + user.getPrenom() + ",\n\n" +
                            "Voici votre lien d'authentification : <a href=\"" + authLink + "\">Lien ici</a>\n" +
                            "Votre login : " + user.getEmail() + "\n" +
                            "Votre mot de passe : " + user.getPassword() + "\n\n" +
                            "Veuillez changer votre mot de passe après votre première connexion.",
                    true); // 'true' indique que le contenu est en HTML

            // Joindre le QR code en tant qu'image
            ByteArrayResource qrCodeAttachment = new ByteArrayResource(qrCodeImage);
            helper.addAttachment("auth_link_qr_code.png", qrCodeAttachment);

            // Envoyer l'e-mail
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Échec de l'envoi de l'e-mail d'authentification", e);
        }
    }
}