package com.mugen.senforage.mapping;

import com.mugen.senforage.entities.CompteurEntity;
import org.mapstruct.Mapper;
import com.mugen.senforage.dto.Compteur;

@Mapper
public interface CompteurMapper {

    // passage du DTO a l'entite
    Compteur toCompteur(CompteurEntity compteurEntity);

    // passage de l'entite au DTO
    CompteurEntity fromCompteur(Compteur compteur);
}
