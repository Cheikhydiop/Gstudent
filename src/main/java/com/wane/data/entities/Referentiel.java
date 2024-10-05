package com.wane.data.entities;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Date;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "referentiels")
@SQLDelete(sql = "UPDATE referentiels SET deleted_at = NOW() WHERE id = ?")
@Where(clause = "deleted_at IS NULL")
public class Referentiel extends AbstractEntity {


    @Column(nullable = false, unique = true)
    private String libelle;

    @Column(nullable = false, unique = true)
    private String code;

    private String description;

    @Enumerated(EnumType.STRING)
    private EtatReferentiel statut = EtatReferentiel.INACTIF;

    private String photoReferentiel;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt = null;



}