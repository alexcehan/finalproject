package com.siit.finalproject.lria.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDtoUpdateRequest {

    private Integer idclients;

    private String first_name;

    private String last_name;

    private Integer age;

    private Integer destination;

    private Integer ticket;
}
