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
public class Facture {
    private int idFacture;
    @NotNull(message = "La consomation mensuelle ne doit pas null")
    private double consoMensuelle;
    @NotNull(message = "La prix par litre ne doit pas null")
    private double prixLitre ;
    @NotNull(message = "La somme en chiffre ne doit pas null")
    private double sommeChiffre;
    @NotNull(message = "La somme en lettre ne doit pas null")
    private String sommeLettre;
    @NotNull
    private Boolean etatFacture;
}
