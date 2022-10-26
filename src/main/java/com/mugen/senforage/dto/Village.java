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
public class Village {
    private int idVillage;
    @NotNull(message = "Le nom du village ne doit pas etre null")
    private String nomVillage;
    @NotNull(message = "Le chef du village ne doit pas etre null")
    private String chefVillage;
}
