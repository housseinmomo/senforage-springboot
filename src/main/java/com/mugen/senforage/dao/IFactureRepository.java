package com.mugen.senforage.dao;

import com.mugen.senforage.entities.FactureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFactureRepository extends JpaRepository<FactureEntity, Integer> {
}
