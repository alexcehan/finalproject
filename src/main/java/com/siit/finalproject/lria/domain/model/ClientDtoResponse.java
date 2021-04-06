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

    private Integer id;

    private String firstName;

    private String lastName;

    private Integer age;

    private FlightDtoResponse flight;

    private TicketDto ticket;

    private Float ticketPrice;

    private String seat;
}
