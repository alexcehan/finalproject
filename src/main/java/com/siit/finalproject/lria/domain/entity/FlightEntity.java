package com.siit.finalproject.lria.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flights")
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idflights")
    private Integer id;

    private Date date;

    private Time time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destination(id)", referencedColumnName = "iddestination")
    private DestinationEntity destination;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "airplane(id)", referencedColumnName = "idairplanes")
    private AirplaneEntity airplane;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "crew(id)", referencedColumnName = "idcrews")
    private CrewEntity crew;

    private Integer available_firstClass_seats;

    private Integer available_bussiness_seats;

    private Integer available_economy_seats;


}
