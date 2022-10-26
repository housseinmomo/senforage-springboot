package com.mugen.senforage.mapping;

import com.mugen.senforage.entities.AdminEntity;
import org.mapstruct.Mapper;
import com.mugen.senforage.dto.Admin;

@Mapper
public interface AdminMappper {

    // passage du DTO a l'entite
    Admin toAdmin(AdminEntity adminEntity);

    // passage de l'entite au DTO
    AdminEntity fromAdmin(Admin admin);
}
