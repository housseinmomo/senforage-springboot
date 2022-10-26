package com.mugen.senforage.dao;

import com.mugen.senforage.entities.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepository extends JpaRepository<AdminEntity, Integer> {
}
