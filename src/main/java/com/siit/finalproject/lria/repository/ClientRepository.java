package com.siit.finalproject.lria.repository;

import com.siit.finalproject.lria.domain.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
}
