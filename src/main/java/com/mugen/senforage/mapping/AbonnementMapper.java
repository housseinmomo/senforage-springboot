package com.mugen.senforage.mapping;


import com.mugen.senforage.dto.Abonnement;
import com.mugen.senforage.entities.AbonnementEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AbonnementMapper {

    // passage du DTO a l'entite
    Abonnement toAbonnement(AbonnementEntity abonnementEntity);

    // passage de l'entite au DTO
    AbonnementEntity fromAbonnement(Abonnement abonnement);
}
