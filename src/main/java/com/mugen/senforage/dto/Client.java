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
public class Client {
    private int idClient;
    @NotNull(message = "La nom de famille ne doit pas null")
    private String nomFamille;
    @NotNull(message = "L'adresse ne doit pas null")
    private String adresse;
    @NotNull(message = "Le telephone ne doit pas null")
    private int telephone;
}
