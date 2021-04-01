package com.siit.finalproject.lria.repository;

import com.siit.finalproject.lria.domain.entity.AirplaneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<AirplaneEntity, Integer> {
}
