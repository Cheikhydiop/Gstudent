package com.wane.data.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "promotion_referentiels")
public class PromotionReferentiel  extends  AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "promo_id")
    private Promotion promotion;

    @ManyToOne
    @JoinColumn(name = "referentiel_id")
    private Referentiel referentiel;

}