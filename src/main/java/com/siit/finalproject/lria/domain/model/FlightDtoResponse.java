package com.siit.finalproject.lria.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.siit.finalproject.lria.domain.entity.DestinationEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightDtoResponse {

    private Integer id;

    private Date date;

    private Time departure_time;

    private DestinationDto destination;

    private AirplaneDto airplane;

    private CrewDto crew;


}
