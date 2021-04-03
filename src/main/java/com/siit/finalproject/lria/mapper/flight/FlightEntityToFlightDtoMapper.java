package com.siit.finalproject.lria.mapper.flight;


import com.siit.finalproject.lria.domain.entity.FlightEntity;
import com.siit.finalproject.lria.domain.model.FlightDto;
import com.siit.finalproject.lria.domain.model.FlightDtoResponse;
import com.siit.finalproject.lria.mapper.CrewEntityToCrewDtoMapper;
import com.siit.finalproject.lria.mapper.airplane.AirplaneEntityToAirplaneDtoMapper;
import com.siit.finalproject.lria.mapper.destination.DestinationEntityToDestinationDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FlightEntityToFlightDtoMapper {
    private final DestinationEntityToDestinationDtoMapper destinationEntityToDestinationDtoMapper;
    private final AirplaneEntityToAirplaneDtoMapper airplaneEntityToAirplaneDtoMapper;
    private final CrewEntityToCrewDtoMapper crewEntityToCrewDtoMapper;

    public FlightDtoResponse mapEntityToDto(FlightEntity flightEntity) {

        return FlightDtoResponse.builder()
                .id(flightEntity.getId())
                .date(flightEntity.getDate())
                .departure_time(flightEntity.getTime())
                .destination(destinationEntityToDestinationDtoMapper.mapEntityToDto(flightEntity.getDestination()))
                .airplane(airplaneEntityToAirplaneDtoMapper.mapEntityToDto(flightEntity.getAirplane()))
                .crew(crewEntityToCrewDtoMapper.mapEntityToDto(flightEntity.getCrew()))
//                .available_bussiness_seats(flightEntity.getAvailable_bussiness_seats())
//                .available_firstclass_seats(flightEntity.getAvailable_firstclass_seats())
//                .available_economy_seats(flightEntity.getAvailable_economy_seats())
                .build();
    }

//        return FlightDto.builder()
//                .id(flightEntity.getId())
//                .date(flightEntity.getDate())
//                .departure_time(flightEntity.getTime())
//                .destination(flightEntity.getDestination())
//                .airplane(flightEntity.getAirplane())
//                .crew(flightEntity.getCrew())
//                .available_bussiness_seats(flightEntity.getAvailable_bussiness_seats())
//                .available_firstclass_seats(flightEntity.getAvailable_firstclass_seats())
//                .available_economy_seats(flightEntity.getAvailable_economy_seats())
//                .build();
//
//    }
}
