package com.mugen.senforage.mapping;

import com.mugen.senforage.entities.GESTCOMPTEUREntity;
import org.mapstruct.Mapper;
import com.mugen.senforage.dto.GESTCOMPTEUR;

@Mapper
public interface GESTCOMPTEURMapper {

    // passage du DTO a l'entites
    GESTCOMPTEUR toGESTCOMPTEUR(GESTCOMPTEUREntity gestcompteurEntity);

    // passage de l'entites au DTO
    GESTCOMPTEUREntity fromGESTCOMPTEUR(GESTCOMPTEUR gestcompteur);
}
