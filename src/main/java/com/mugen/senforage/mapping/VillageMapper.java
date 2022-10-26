package com.mugen.senforage.mapping;

import com.mugen.senforage.dto.Village;
import com.mugen.senforage.entities.VillageEntity;
import org.mapstruct.Mapper;

@Mapper
public interface VillageMapper {

    // passage du DTO a l'entites
    Village toVillage(VillageEntity villageEntity);

    // passage de l'entites au DTO
    VillageEntity fromVIllage(Village village);
}
