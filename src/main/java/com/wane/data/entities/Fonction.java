package com.wane.data.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fonctions")
public class Fonction extends  AbstractEntity {

    @Column(nullable = false, unique = true)
    private String libelle;

    private String description;

}