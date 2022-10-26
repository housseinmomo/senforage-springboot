package com.mugen.senforage.mapping;

import com.mugen.senforage.entities.GESTCLIENTELEEntity;
import org.mapstruct.Mapper;
import com.mugen.senforage.dto.GESTCLIENTELE;

@Mapper
public interface GESTCLIENTELEMapper {

    // passage du DTO a l'entites
    GESTCLIENTELE toGESTCLIENTELE(GESTCLIENTELEEntity gestclienteleEntity);

    // passage de l'entite au DTO
    GESTCLIENTELEEntity fromGESTCLIENTELE(GESTCLIENTELE gestclientele);
}
