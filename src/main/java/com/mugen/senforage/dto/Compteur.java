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
public class Compteur {
    private int idCompteur;
    @NotNull(message = "La cumul de la consommation ne doit pas null")
    private double cumulConso;
    @NotNull
    private Boolean etatCompteur;
}
