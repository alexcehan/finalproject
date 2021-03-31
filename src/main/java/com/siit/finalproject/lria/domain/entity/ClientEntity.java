package com.siit.finalproject.lria.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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

    private String first_name;

    private String last_name;

    private Integer age;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destination", referencedColumnName = "iddestination")
    private DestinationEntity destination;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticket", referencedColumnName = "idticket_type")
    private TicketEntity ticket;
}
