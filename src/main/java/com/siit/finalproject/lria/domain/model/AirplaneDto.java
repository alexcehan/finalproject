package com.siit.finalproject.lria.domain.model;


import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class AirplaneDto {

    private Integer id;

    private String airplane_name;

    private String equipment;

    private String manufacturer;

    private Integer age;


}
