package com.siit.finalproject.lria.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDtoCreateRequest {

    private Integer id;


    private String firstName;


    private String lastName;


    private Integer age;

    private Integer flightId;

    private Integer ticketId;



}
