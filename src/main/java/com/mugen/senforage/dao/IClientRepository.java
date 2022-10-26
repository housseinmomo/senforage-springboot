package com.mugen.senforage.dao;

import com.mugen.senforage.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<ClientEntity, Integer> {
}
