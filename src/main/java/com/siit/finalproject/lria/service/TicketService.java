package com.siit.finalproject.lria.service;
import com.siit.finalproject.lria.domain.entity.AirplaneEntity;
import com.siit.finalproject.lria.domain.entity.DestinationEntity;
import com.siit.finalproject.lria.domain.entity.FlightEntity;
import com.siit.finalproject.lria.domain.entity.TicketEntity;
import com.siit.finalproject.lria.domain.model.ClientDtoCreateRequest;
import com.siit.finalproject.lria.exception.FlightNotFoundException;
import com.siit.finalproject.lria.exception.TicketNotFoundException;
import com.siit.finalproject.lria.repository.FlightRepository;
import com.siit.finalproject.lria.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final FlightRepository flightRepository;
    private final TicketRepository ticketRepository;


    public ClientDtoCreateRequest getTicketPrice(ClientDtoCreateRequest clientDtoCreateRequest, int availableTickets) {
        FlightEntity flightEntity = flightRepository.findById(clientDtoCreateRequest.getFlightId()).orElseThrow(()-> new FlightNotFoundException("No flight found for the given id: "+clientDtoCreateRequest.getFlightId()));
        TicketEntity ticketEntity = ticketRepository.findById(clientDtoCreateRequest.getTicketId()).orElseThrow(()-> new TicketNotFoundException("No ticket type found for the given id: "+clientDtoCreateRequest.getTicketId()));
        DestinationEntity destinationEntity = flightEntity.getDestination();
        AirplaneEntity airplaneEntity = flightEntity.getAirplane();
        int initialAvailableSeats;
        String seat;
        NumberFormat numberFormat = new DecimalFormat("#0.00");


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
            clientDtoCreateRequest.setTicketPrice(Float.parseFloat(numberFormat.format((distance * 0.02f) * 15 + (30f*(initialAvailableSeats/availableTickets)) + (720f/hoursToTakeOf * 3))));
            seat = ((initialAvailableSeats - availableTickets + 1) + "A");
            clientDtoCreateRequest.setSeat(seat);

        } else if (ticketClass == 2) {
            initialAvailableSeats = airplaneEntity.getBusiness_class_seats();
            clientDtoCreateRequest.setTicketPrice(Float.parseFloat(numberFormat.format((distance * 0.02f) * 10 + (20f*(initialAvailableSeats/availableTickets)) + (720f/hoursToTakeOf * 2))));
            seat = ((initialAvailableSeats - availableTickets + 1) + "B");
            clientDtoCreateRequest.setSeat(seat);
        } else {
            initialAvailableSeats = airplaneEntity.getEconomic_class_seats();
            clientDtoCreateRequest.setTicketPrice(Float.parseFloat(numberFormat.format((distance * 0.02f) * 4 + (10f*(initialAvailableSeats/availableTickets)) + (720f/hoursToTakeOf))));
            seat = ((initialAvailableSeats - availableTickets + 1) + "C");
            clientDtoCreateRequest.setSeat(seat);
        }



        return clientDtoCreateRequest;
    }

}
