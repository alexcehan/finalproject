package com.siit.finalproject.lria.domain.model;

import com.siit.finalproject.lria.domain.entity.FlightEntity;
import com.siit.finalproject.lria.domain.entity.TicketEntity;
import lombok.Builder;
import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

@Builder
@Data
public class ClientDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private Integer age;

    private FlightEntity flight;

    private TicketEntity ticket;
}
