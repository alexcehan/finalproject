package com.siit.finalproject.lria.repository;

import com.siit.finalproject.lria.domain.entity.CrewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewRepository extends JpaRepository<CrewEntity, Integer> {
}
