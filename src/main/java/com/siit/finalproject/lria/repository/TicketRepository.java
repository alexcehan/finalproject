package com.siit.finalproject.lria.repository;

import com.siit.finalproject.lria.domain.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
}
