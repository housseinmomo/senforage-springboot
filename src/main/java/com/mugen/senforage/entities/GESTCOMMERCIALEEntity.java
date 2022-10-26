package com.mugen.senforage.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GESTCOMMERCIALEEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGestCommerciale;
    @Column(length = 50 , nullable = false)
    private String nom;
    @Column(length = 50 , nullable = false)
    private String prenom;
    @Column(length = 50 , nullable = false)
    private String email;
    @Column(length = 150 , nullable = false)
    private String mdp;
    @Column
    private Boolean etat;
    @ManyToOne	// Un gestionnaire commerciale peuvent avoir le meme role
    private RolesEntity role;
    @ManyToOne	// plusieurs commerciale clienteles peuvent etre creer par un seule admin
    private AdminEntity adminEntity;
    @OneToMany(mappedBy = "gest_commerciale")
    private List<FactureEntity> factureEntityEntities = new ArrayList<FactureEntity>();

}
