package com.siit.finalproject.lria.mapper.client;


import com.siit.finalproject.lria.domain.model.ClientDtoCreateRequest;
import com.siit.finalproject.lria.domain.model.ClientDtoResponse;
import com.siit.finalproject.lria.repository.FlightRepository;
import com.siit.finalproject.lria.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientDtoToClientDtoCreateRequest {
    private final FlightRepository flightRepository;
    private final TicketRepository ticketRepository;

    public ClientDtoCreateRequest mapDtoToDtoCreateRequest(ClientDtoResponse clientDtoResponse) {

        return ClientDtoCreateRequest.builder()
                .ticketId(clientDtoResponse.getTicket().getId())
                .build();

    }

}
