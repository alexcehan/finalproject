package com.siit.finalproject.lria.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DestinationDto {

    private Integer id;

    private String city;

    private String country;

    private Time flying_time;

    private Integer distance_to_fly;
}
