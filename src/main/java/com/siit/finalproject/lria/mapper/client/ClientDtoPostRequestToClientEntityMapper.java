package com.siit.finalproject.lria.mapper.client;


import com.siit.finalproject.lria.domain.entity.ClientEntity;
import com.siit.finalproject.lria.domain.model.ClientDtoCreateRequest;
import com.siit.finalproject.lria.exception.DestinationNotFoundException;
import com.siit.finalproject.lria.exception.FlightNotFoundException;
import com.siit.finalproject.lria.exception.TicketNotFoundException;
import com.siit.finalproject.lria.repository.DestinationRepository;
import com.siit.finalproject.lria.repository.FlightRepository;
import com.siit.finalproject.lria.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
@RequiredArgsConstructor
public class ClientDtoPostRequestToClientEntityMapper {

    private final FlightRepository flightRepository;
    private final TicketRepository ticketRepository;

    public ClientEntity mapDtoPostRequestToEntity(ClientDtoCreateRequest clientDtoCreateRequest) {


        return ClientEntity.builder()
                .firstName(clientDtoCreateRequest.getFirstName())
                .lastName(clientDtoCreateRequest.getLastName())
                .age(clientDtoCreateRequest.getAge())
                .flight(flightRepository.findById(clientDtoCreateRequest.getFlightId())
                        .orElseThrow(() -> new FlightNotFoundException("Flight Not Found for Id: " + clientDtoCreateRequest.getFlightId())))
                .ticket(ticketRepository.findById(clientDtoCreateRequest.getTicketId())
                        .orElseThrow(() -> new TicketNotFoundException("Ticket not available for this id: " + clientDtoCreateRequest.getTicketId())))
                .ticketPrice(clientDtoCreateRequest.getTicketPrice())
                .seat(clientDtoCreateRequest.getSeat())
                .build();
    }


}
