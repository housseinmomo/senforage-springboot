package com.mugen.senforage.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VillageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVillage;
    @Column(length = 150 , nullable = false)
    private String nomVillage;
    @Column(length = 150 , nullable = false)
    private String chefVillage;
    @OneToMany(mappedBy = "villageEntity")
    private List<ClientEntity> clients = new ArrayList<ClientEntity>();
}
