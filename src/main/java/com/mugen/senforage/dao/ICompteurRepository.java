package com.mugen.senforage.dao;

import com.mugen.senforage.entities.CompteurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompteurRepository extends JpaRepository<CompteurEntity, Integer> {
}
