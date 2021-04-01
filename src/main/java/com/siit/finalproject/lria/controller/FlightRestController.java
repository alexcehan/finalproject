package com.siit.finalproject.lria.controller;

import com.siit.finalproject.lria.domain.model.FlightDtoResponse;
import com.siit.finalproject.lria.service.FlightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/flights")
public class FlightRestController {

    private final FlightService flightService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FlightDtoResponse> getAllFlights() {
        return flightService.getAllFlights();
    }
}
