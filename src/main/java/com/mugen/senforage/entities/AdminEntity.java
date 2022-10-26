package com.mugen.senforage.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdminEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAdmin;
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
    @OneToOne // un admin a un seule role
    private RolesEntity role;
    @OneToMany(mappedBy = "adminEntity")
    private List<GESTCLIENTELEEntity> gestClients = new ArrayList<GESTCLIENTELEEntity>();
    @OneToMany(mappedBy = "adminEntity")
    private List<GESTCOMMERCIALEEntity> gestCommerciales = new ArrayList<GESTCOMMERCIALEEntity>();
    @OneToMany(mappedBy = "adminEntity")
    private List<GESTCOMPTEUREntity> gestCompteurs = new ArrayList<GESTCOMPTEUREntity>();

}
