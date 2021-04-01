package com.siit.finalproject.lria.mapper;

import com.siit.finalproject.lria.domain.entity.AirplaneEntity;
import com.siit.finalproject.lria.domain.model.AirplaneDto;
import org.springframework.stereotype.Component;

@Component
public class AirplaneEntityToAirplaneDtoMapper {
    public AirplaneDto mapEntityToDto(AirplaneEntity airplaneEntity) {
        return AirplaneDto.builder()
                .id(airplaneEntity.getId())
                .airplane_name(airplaneEntity.getAirplane_name())
                .equipment(airplaneEntity.getEquipment())
                .manufacturer(airplaneEntity.getManufacturer())
                .age(airplaneEntity.getAge())
                .first_class_seats(airplaneEntity.getFirst_class_seats())
                .bussiness_class_seats(airplaneEntity.getBussiness_class_seats())
                .economic_class_seats(airplaneEntity.getEconomic_class_seats())
                .build();
    }
}
