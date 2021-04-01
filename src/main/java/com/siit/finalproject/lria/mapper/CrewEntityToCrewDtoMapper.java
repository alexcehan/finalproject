package com.siit.finalproject.lria.mapper;

import com.siit.finalproject.lria.domain.entity.AirplaneEntity;
import com.siit.finalproject.lria.domain.entity.CrewEntity;
import com.siit.finalproject.lria.domain.model.AirplaneDto;
import com.siit.finalproject.lria.domain.model.CrewDto;
import org.springframework.stereotype.Component;

@Component
public class CrewEntityToCrewDtoMapper {
    public CrewDto mapEntityToDto(CrewEntity crewEntity) {
        return CrewDto.builder()
                .id(crewEntity.getId())
                .pilot(crewEntity.getPilot())
                .copilot(crewEntity.getCopilot())
                .build();
    }


}
