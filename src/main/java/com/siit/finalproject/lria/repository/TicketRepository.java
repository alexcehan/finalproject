package com.siit.finalproject.lria.repository;

import com.siit.finalproject.lria.domain.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
}
