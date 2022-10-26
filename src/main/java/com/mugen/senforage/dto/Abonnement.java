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
public class Abonnement  {
    private int idAbonnement;
    @NotNull(message = "La date ne doit pas null")
    private java.util.Date dateAbonnement;
    @NotNull(message = "La description ne doit pas null")
    private String description;
}
