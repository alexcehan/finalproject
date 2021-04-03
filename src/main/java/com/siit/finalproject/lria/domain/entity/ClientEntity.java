package com.siit.finalproject.lria.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")

public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idclients")
    private Integer id;


    private String firstName;


    private String lastName;

    private Integer age;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flightid", referencedColumnName = "idflights")
    private FlightEntity flight;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticketid", referencedColumnName = "idticket_type")
    private TicketEntity ticket;
}
