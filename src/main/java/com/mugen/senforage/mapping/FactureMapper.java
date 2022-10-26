package com.mugen.senforage.mapping;

import com.mugen.senforage.entities.FactureEntity;
import org.mapstruct.Mapper;
import com.mugen.senforage.dto.Facture;

@Mapper
public interface FactureMapper {

    // passage du DTO a l'entites
    Facture toFacture(FactureEntity factureEntity);

    // passage de l'entite au DTO
    FactureEntity fromFacture(Facture facture);

}
