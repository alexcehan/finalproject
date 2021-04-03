package com.siit.finalproject.lria.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
public class AirplaneDto {

    private Integer id;

    private String airplane_name;

    private String equipment;

    private String manufacturer;

    private Integer age;

//    private Integer first_class_seats;
//
//    private Integer bussiness_class_seats;
//
//    private Integer economic_class_seats;
}
