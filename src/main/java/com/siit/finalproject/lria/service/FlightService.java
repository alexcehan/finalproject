package com.siit.finalproject.lria.service;

import com.siit.finalproject.lria.domain.model.FlightDtoResponse;
import com.siit.finalproject.lria.mapper.FlightEntityToFlightDtoMapper;
import com.siit.finalproject.lria.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;
    private final FlightEntityToFlightDtoMapper flightEntityToFlightDtoMapper;

    @Transactional(readOnly = true)
    public List<FlightDtoResponse> getAllFlights() {
        return flightRepository.findAll()
                .stream()
                .map(flightEntity -> flightEntityToFlightDtoMapper.mapEntityToDto(flightEntity))
                .collect(toList());
    }

}
