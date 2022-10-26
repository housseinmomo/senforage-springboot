package com.mugen.senforage.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FactureEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFacture;
    @Column(nullable = false)
    private double consoMensuelle;
    @Column(nullable = false)
    private double prixLitre ;
    @Column(nullable = false)
    private double sommeChiffre;
    @Column(length = 200, nullable = false)
    private String sommeLettre;
    @Column
    private Boolean etatFacture;
    @ManyToOne // plusieurs factures peuvent etre enregistrer par le gestionnaire commerciale
    private GESTCOMMERCIALEEntity gest_commerciale;
    @ManyToOne
    private ClientEntity clientEntity;

}
