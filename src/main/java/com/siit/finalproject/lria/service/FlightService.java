package com.siit.finalproject.lria.service;

import com.siit.finalproject.lria.domain.entity.DestinationEntity;
import com.siit.finalproject.lria.domain.model.FlightDtoResponse;
import com.siit.finalproject.lria.exception.FlightNotFoundException;
import com.siit.finalproject.lria.mapper.flight.FlightEntityToFlightDtoMapper;
import com.siit.finalproject.lria.repository.DestinationRepository;
import com.siit.finalproject.lria.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;
    private final DestinationRepository destinationRepository;
    private final FlightEntityToFlightDtoMapper flightEntityToFlightDtoMapper;

    @Transactional(readOnly = true)
    public List<FlightDtoResponse> getAllFlights() {
        return flightRepository.findAll()
                .stream()
                .map(flightEntity -> flightEntityToFlightDtoMapper.mapEntityToDto(flightEntity))
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public FlightDtoResponse getFlightById(Integer id) {
        return flightEntityToFlightDtoMapper.mapEntityToDto(flightRepository.findById(id).orElseThrow(() -> new FlightNotFoundException("No flight was found with this id!")));
    }

    @Transactional(readOnly = true)
    public List<FlightDtoResponse> getAllFlightsByDate(Date date) {
        return flightRepository.findAllByDate(date)
                .stream()
                .map(flightEntity -> flightEntityToFlightDtoMapper.mapEntityToDto(flightEntity))
                .collect(toList());
    }

    public List<FlightDtoResponse> getAllFlightsByDestination(String city) {
        DestinationEntity destinationEntity = destinationRepository.findByCity(city);

        return flightRepository.findAllByDestination(destinationEntity)
                .stream()
                .map(flightEntity -> flightEntityToFlightDtoMapper.mapEntityToDto(flightEntity))
                .collect(toList());
    }


    public List<FlightDtoResponse> getAllFlightsByDestinationAndDate(String city, Date date) {
        DestinationEntity destinationEntity = destinationRepository.findByCity(city);

        return flightRepository.findAllByDestinationAndDate(destinationEntity, date)
                .stream()
                .map(flightEntity -> flightEntityToFlightDtoMapper.mapEntityToDto(flightEntity))
                .collect(toList());


    }

}
