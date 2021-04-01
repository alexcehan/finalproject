package com.siit.finalproject.lria.domain.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;
import java.sql.Time;

@Builder
@Data
public class FlightDto {

    private Integer id;

    private Date date;

    private Time departure_time;

    private Integer destination;

    private Integer airplane;

    private Integer crew;
}
