package com.siit.finalproject.lria.repository;

import com.siit.finalproject.lria.domain.entity.DestinationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends JpaRepository<DestinationEntity, Integer> {
}
