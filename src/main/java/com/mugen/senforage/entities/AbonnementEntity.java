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
public class AbonnementEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAbonnement;
    @Column
    private java.util.Date dateAbonnement;
    @Column(length = 255, nullable = false)
    private String description;
    @ManyToOne
    private GESTCLIENTELEEntity gest_client;
    @OneToMany(mappedBy = "abonnementEntity")
    private List<ClientEntity> clients = new ArrayList<ClientEntity>();


}
