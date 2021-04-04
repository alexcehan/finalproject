package com.siit.finalproject.lria.repository;

import com.siit.finalproject.lria.domain.entity.ClientEntity;
import com.siit.finalproject.lria.domain.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
    List<ClientEntity> findAllByFirstNameAndLastName(String firstName, String lastName);
    List<ClientEntity> findAllByLastName(String lastName);
    List<ClientEntity> findAllByFlightId(Integer flight_id);

}
