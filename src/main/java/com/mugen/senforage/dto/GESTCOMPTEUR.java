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
public class GESTCOMPTEUR  {
    private int idGestCompteur;
    @NotNull(message = "Le nom ne doit pas null")
    private String nom;
    @NotNull(message = "Le prenom ne doit pas null")
    private String prenom;
    @NotNull(message = "L'email ne doit pas null")
    private String email;
    @NotNull(message = "Le password ne doit pas null")
    private String mdp;
    @NotNull
    private Boolean etat;
}
