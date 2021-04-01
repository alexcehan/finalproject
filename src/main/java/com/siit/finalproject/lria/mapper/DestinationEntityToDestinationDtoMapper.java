package com.siit.finalproject.lria.mapper;

import com.siit.finalproject.lria.domain.entity.DestinationEntity;
import com.siit.finalproject.lria.domain.model.DestinationDto;
import org.springframework.stereotype.Component;

@Component
public class DestinationEntityToDestinationDtoMapper {

    public DestinationDto mapEntityToDto(DestinationEntity destinationEntity) {
        if (destinationEntity == null) {
            return null;
        }
        return DestinationDto.builder()
                .id(destinationEntity.getId())
                .city(destinationEntity.getCity())
                .country(destinationEntity.getCountry())
                .flying_time(destinationEntity.getFlying_time())
                .distance_to_fly(destinationEntity.getDistance_to_fly())
                .build();
    }
}
