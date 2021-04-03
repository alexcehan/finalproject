package com.siit.finalproject.lria.mapper.client;

import com.siit.finalproject.lria.domain.entity.ClientEntity;
import com.siit.finalproject.lria.domain.model.ClientDtoResponse;
import com.siit.finalproject.lria.mapper.destination.DestinationEntityToDestinationDtoMapper;
import com.siit.finalproject.lria.mapper.flight.FlightEntityToFlightDtoMapper;
import com.siit.finalproject.lria.mapper.ticket.TicketEntityToTicketDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientEntityToClientDtoMapper {

    private final TicketEntityToTicketDtoMapper ticketEntityToTicketDtoMapper;
    private final DestinationEntityToDestinationDtoMapper destinationEntityToDestinationDtoMapper;
    private final FlightEntityToFlightDtoMapper flightEntityToFlightDtoMapper;

    public ClientDtoResponse mapEntityToDto(ClientEntity clientEntity) {
        return ClientDtoResponse.builder()
                .id(clientEntity.getId())
                .firstName(clientEntity.getFirstName())
                .lastName(clientEntity.getLastName())
                .age(clientEntity.getAge())
                .flight(flightEntityToFlightDtoMapper.mapEntityToDto(clientEntity.getFlight()))
                .ticket(ticketEntityToTicketDtoMapper.mapEntityToDto(clientEntity.getTicket()))
                .build();
    }
}
