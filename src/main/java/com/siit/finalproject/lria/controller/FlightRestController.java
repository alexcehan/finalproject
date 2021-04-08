package com.siit.finalproject.lria.controller;

import com.siit.finalproject.lria.domain.model.FlightDtoResponse;
import com.siit.finalproject.lria.service.FlightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/flights")
public class FlightRestController {

    private final FlightService flightService;


    //returns all flights
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FlightDtoResponse> getAllFlights() {
        return flightService.getAllFlights();
    }

    //returns flight by Id
    @GetMapping(value = "/flightId",produces = MediaType.APPLICATION_JSON_VALUE)
    public FlightDtoResponse getFlightById(@RequestParam(name = "flightId") Integer flightId) {
        return flightService.getFlightById(flightId);
    }

    //return flights by specified departure date
    @GetMapping(value = "/flightsByDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FlightDtoResponse> getAllFlightsByDate(@RequestParam(name = "date") Date date) {
        return flightService.getAllFlightsByDate(date);
    }

    //return flights by specified destination
    @GetMapping(value = "/flightsByDestination", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FlightDtoResponse> getAllFlightsByDestination(@RequestParam(name = "city") String city) {
        return flightService.getAllFlightsByDestination(city);
    }

    //return flights by specified departure date and destination
    @GetMapping(value = "/flightsByDestinationAndDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FlightDtoResponse> getAllFlightsByDestinationAndDate(@RequestParam(name = "city") String city,
                                                                     @RequestParam(name = "date") Date date) {
        return flightService.getAllFlightsByDestinationAndDate(city, date);
    }


}
