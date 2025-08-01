package com.ctw.workstation.teammember.entity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "cdi")
public interface TeamMemberMapper {
    TeamMemberMapper INSTANCE = Mappers.getMapper(TeamMemberMapper.class);

    default TeamMemberDTO toDTO(TeamMember teamMember) {
        if (teamMember == null) return null;

        return new TeamMemberDTO(
                teamMember.getId(),
                teamMember.getTeamId(),
                teamMember.getCtwId(),
                teamMember.getName(),
                teamMember.getModifiedAt()
        );
    }

    @Mapping(target = "team", ignore = true)
    TeamMember toEntity(TeamMemberDTO dto);

}