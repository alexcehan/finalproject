package com.siit.finalproject.lria.domain.model;

import com.siit.finalproject.lria.domain.entity.AirplaneEntity;
import com.siit.finalproject.lria.domain.entity.CrewEntity;
import com.siit.finalproject.lria.domain.entity.DestinationEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;
import java.sql.Time;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto {

    private Integer id;

    private Date date;

    private Time departure_time;

    private DestinationEntity destination;

    private AirplaneEntity airplane;

    private CrewEntity crew;


}
