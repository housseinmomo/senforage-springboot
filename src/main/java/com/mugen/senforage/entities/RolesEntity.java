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
public class RolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;
    @Column(length = 120, nullable = false)
    private String role;
    @OneToMany(mappedBy = "role")
    private List<GESTCLIENTELEEntity> gestClients = new ArrayList<GESTCLIENTELEEntity>();
    @OneToMany(mappedBy = "role")
    private List<GESTCOMMERCIALEEntity> gestCommerciales = new ArrayList<GESTCOMMERCIALEEntity>();
    @OneToMany(mappedBy = "role")
    private List<GESTCOMPTEUREntity> gestCompteurs = new ArrayList<GESTCOMPTEUREntity>();
}
