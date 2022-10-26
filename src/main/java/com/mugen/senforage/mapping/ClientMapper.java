package com.mugen.senforage.mapping;

import com.mugen.senforage.entities.ClientEntity;
import org.mapstruct.Mapper;
import com.mugen.senforage.dto.Client;

@Mapper
public interface ClientMapper {

    // passage du DTO a l'entite
    Client toClient(ClientEntity clientEntity);

    // passage de l'entite au DTO
    ClientEntity fromClient(Client client);

}
