package com.siit.finalproject.lria.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDtoResponse {

    private Integer idclients;

    private String first_name;

    private String last_name;

    private Integer age;

    private DestinationDto destination;

    private TicketDto ticket;
}
