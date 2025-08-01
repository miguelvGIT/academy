package com.ctw.workstation.team.entity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "cdi")
public interface TeamMapper {

    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    default TeamDTO toDTO(Team team) {
        if (team == null) return null;

        return new TeamDTO(
                team.getId(),
                team.getName(),
                team.getProduct(),
                team.getCreatedAt(),
                team.getModifiedAt(),
                team.getDefaultLocation()
        );
    }

     default Team toEntity(TeamDTO dto) {
        if (dto == null) return null;

        Team team = new Team();

        team.setName(dto.getName());
        team.setProduct(dto.getProduct());
        team.setCreatedAt(dto.getCreatedAt());
        team.setDefaultLocation(dto.getDefaultLocation());
        team.setModifiedAt(dto.getModifiedAt());

        return team;
    }
}
