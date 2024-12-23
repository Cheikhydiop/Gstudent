package com.wane.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    private String adresse;

    @Column(unique = true)
    private String telephone;

    private String photo;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "fonction_id")
    private Fonction fonction;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Enumerated(EnumType.STRING)
    private EtatUser statut = EtatUser.INACTIF;
}