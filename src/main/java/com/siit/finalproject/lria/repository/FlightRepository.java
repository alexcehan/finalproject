package com.siit.finalproject.lria.repository;

import com.siit.finalproject.lria.domain.entity.DestinationEntity;
import com.siit.finalproject.lria.domain.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Integer> {

    List<FlightEntity> findAllByDate(Date date);
    List<FlightEntity> findAllByDestination(DestinationEntity city);
    List<FlightEntity> findAllByDestinationAndDate(DestinationEntity city, Date date);


}
