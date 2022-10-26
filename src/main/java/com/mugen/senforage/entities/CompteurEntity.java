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
public class CompteurEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompteur;
    @Column
    private double cumulConso;
    @Column
    private Boolean etatCompteur;
    @OneToOne
    private ClientEntity clientEntity;

}
