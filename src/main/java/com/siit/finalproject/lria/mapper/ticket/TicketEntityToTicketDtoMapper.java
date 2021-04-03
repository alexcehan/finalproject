package com.siit.finalproject.lria.mapper.ticket;

import com.siit.finalproject.lria.domain.entity.TicketEntity;
import com.siit.finalproject.lria.domain.model.TicketDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketEntityToTicketDtoMapper {

    public TicketDto mapEntityToDto(TicketEntity ticketEntity) {
        return TicketDto.builder()
                .id(ticketEntity.getId())
                .ticket_class(ticketEntity.getTicket_class())
                .drink_included(ticketEntity.isDrink_included())
                .meal_included(ticketEntity.isMeal_included())
                .build();
    }
}
