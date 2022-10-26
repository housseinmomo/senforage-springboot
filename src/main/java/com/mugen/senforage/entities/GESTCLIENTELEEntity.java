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
public class GESTCLIENTELEEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGestClient;
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
    @ManyToOne	// Un gestionnaire clientele peuvent avoir le meme role
    private RolesEntity role;
    @ManyToOne	// plusieurs gestionnaires clienteles peuvent etre creer par un seule admin
    private AdminEntity adminEntity;
    @OneToMany(mappedBy = "gest_client")
    private List<AbonnementEntity> abonnementEntities = new ArrayList<AbonnementEntity>();
    @OneToMany(mappedBy = "gest_client")
    private List<ClientEntity> clientEntityEntities = new ArrayList<ClientEntity>();
}
