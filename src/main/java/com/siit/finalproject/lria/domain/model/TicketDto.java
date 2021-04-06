package com.siit.finalproject.lria.domain.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TicketDto {

    private Integer id;

    private String ticket_class;

    private boolean meal_included;

    private boolean drink_included;




}
