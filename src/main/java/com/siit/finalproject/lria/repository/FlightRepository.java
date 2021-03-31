package com.siit.finalproject.lria.repository;

import com.siit.finalproject.lria.domain.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<FlightEntity, Integer> {
}
