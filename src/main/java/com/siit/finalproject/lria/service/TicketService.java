package com.siit.finalproject.lria.service;

import com.siit.finalproject.lria.domain.entity.AirplaneEntity;
import com.siit.finalproject.lria.domain.entity.DestinationEntity;
import com.siit.finalproject.lria.domain.entity.FlightEntity;
import com.siit.finalproject.lria.domain.entity.TicketEntity;
import com.siit.finalproject.lria.domain.model.ClientDtoCreateRequest;
import com.siit.finalproject.lria.repository.DestinationRepository;
import com.siit.finalproject.lria.repository.FlightRepository;
import com.siit.finalproject.lria.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class TicketService {

    FlightRepository flightRepository;
    TicketRepository ticketRepository;
    DestinationRepository destinationRepository;

    public double getTicketPrice(ClientDtoCreateRequest clientDtoCreateRequest, int availableTickets) {
        FlightEntity flightEntity = flightRepository.findById(clientDtoCreateRequest.getFlightId()).orElseThrow();
        TicketEntity ticketEntity = ticketRepository.findById(clientDtoCreateRequest.getTicketId()).orElseThrow();
        DestinationEntity destinationEntity = flightEntity.getDestination();
        AirplaneEntity airplaneEntity = flightEntity.getAirplane();
        int initialAvailableSeats = 0;


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Date takeOffDate = flightEntity.getDate();
        Time takeOffHour = flightEntity.getTime();
        String dateTimeToParse = (takeOffDate.toString() + " " + takeOffHour.toString());
        LocalDateTime takeOffTime = LocalDateTime.parse(dateTimeToParse, formatter);
        int hoursToTakeOf = (int)((Duration.between(LocalDateTime.now(), takeOffTime)).getSeconds() / 3600);

        int ticketClass = ticketEntity.getId();

        int distance = destinationEntity.getDistance_to_fly();

        if (ticketClass == 1) {
            initialAvailableSeats = airplaneEntity.getFirst_class_seats();
            return ((distance * 0.02) * 15 + (30*(initialAvailableSeats/availableTickets)) + (720/hoursToTakeOf * 3));
        } else if (ticketClass == 2) {
            initialAvailableSeats = airplaneEntity.getBussiness_class_seats();
            return ((distance * 0.02) * 10 + (20*(initialAvailableSeats/availableTickets)) + (720/hoursToTakeOf * 2));
        } else {
            initialAvailableSeats = airplaneEntity.getEconomic_class_seats();
            return ((distance * 0.02) * 4 + (10*(initialAvailableSeats/availableTickets)) + (720/hoursToTakeOf));
        }

    }

}
