package com.wane.service;

import com.wane.data.entities.User;
import com.wane.data.repository.UserRepository;
import com.wane.web.dto.request.CreateApprenantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUserApprenant(CreateApprenantRequest request) {
        User user = new User();
        user.setNom(request.getNomTuteur());
        user.setPrenom(request.getPrenomTuteur());
        user.setEmail(request.getEmail());
        user.setPassword("defaultPassword"); // ou générez un mot de passe aléatoire
        // autres propriétés à setter si nécessaire

        // Sauvegarde de l'utilisateur dans le repository
        return userRepository.save(user);
    }
}