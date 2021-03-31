package com.siit.finalproject.lria.repository;

import com.siit.finalproject.lria.domain.entity.AirplaneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository extends JpaRepository<AirplaneEntity, Integer> {
}
