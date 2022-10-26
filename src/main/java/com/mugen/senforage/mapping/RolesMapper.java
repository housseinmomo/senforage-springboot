package com.mugen.senforage.mapping;

import com.mugen.senforage.entities.RolesEntity;
import org.mapstruct.Mapper;
import com.mugen.senforage.dto.Roles;

@Mapper
public interface RolesMapper {

    // passage de l'entites au DTO
    Roles toRoles(RolesEntity rolesEntity);

    // passage du DTO a l'entites
    RolesEntity fromRoles(Roles roles);

}
