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
public class GESTCOMPTEUREntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGestCompteur;
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
    @ManyToOne	// Un gestionnaire compteur peuvent avoir le meme role
    private RolesEntity role;
    @ManyToOne	// plusieurs gestionnaires compteurs peuvent etre creer par un seule admin
    private AdminEntity adminEntity;
    @OneToMany(mappedBy = "gest_compteur")
    private List<ClientEntity> clientEntityEntities = new ArrayList<ClientEntity>();

}
