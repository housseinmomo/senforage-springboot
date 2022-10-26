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
public class ClientEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;
    @Column(length = 150, nullable = false)
    private String nomFamille;
    @ManyToOne
    private VillageEntity villageEntity;
    @Column(length = 150, nullable = false)
    private String adresse;
    @Column(length = 100, nullable = false)
    private int telephone;
    @ManyToOne
    private GESTCLIENTELEEntity gest_client;
    @ManyToOne
    private AbonnementEntity abonnementEntity;
    @ManyToOne
    private GESTCOMPTEUREntity gest_compteur;
    @OneToMany(mappedBy = "clientEntity")
    private List<FactureEntity> factureEntities = new ArrayList<FactureEntity>();

}
