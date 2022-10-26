package com.mugen.senforage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Admin {
    private int idAdmin;
    @NotNull(message = "La nom ne doit pas null")
    private String nom;
    @NotNull(message = "La prenom ne doit pas null")
    private String prenom;
    @NotNull(message = "L'email ne doit pas null")
    private String email;
    @NotNull(message = "La password ne doit pas null")
    private String mdp;
    @NotNull
    private Boolean etat;
}
