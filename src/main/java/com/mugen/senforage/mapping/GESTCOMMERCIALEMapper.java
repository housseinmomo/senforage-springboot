package com.mugen.senforage.mapping;

import com.mugen.senforage.entities.GESTCOMMERCIALEEntity;
import org.mapstruct.Mapper;
import com.mugen.senforage.dto.GESTCOMMERCIALE;

@Mapper
public interface GESTCOMMERCIALEMapper {

    // passage du DTO a l'entites
    GESTCOMMERCIALE toGESTCOMMERCIALE(GESTCOMMERCIALEEntity gestcommercialeEntity);

    // passage de l'entites au DTO
    GESTCOMMERCIALEEntity fromGESTCOMMERCIALE(GESTCOMMERCIALE gestcommerciale);
}
