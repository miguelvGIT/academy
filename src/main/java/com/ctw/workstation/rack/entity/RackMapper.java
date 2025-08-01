package com.ctw.workstation.rack.entity;

import com.ctw.workstation.teammember.entity.TeamMemberMapper;
import jakarta.ws.rs.WebApplicationException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "cdi")
public interface RackMapper {

    RackMapper INSTANCE = Mappers.getMapper(RackMapper.class);

    default RackDTO toDTO(Rack rack) {
        if (rack == null) return null;

        return new RackDTO(
                rack.getId(),
                rack.getSerialNumber(),
                rack.getStatus() != null ? rack.getStatus().name() : null,
                rack.getTeamId(),
                rack.getDefaultLocation(),
                rack.getModifiedAt()
        );
    }

    @Mapping(target = "rack", ignore = true)
    default Rack toEntity(RackDTO dto) {
        if (dto == null) return null;

        Rack rack = new Rack();

        rack.setSerialNumber(dto.getSerialNumber());

        if (dto.getStatus() != null) {
            try {
                rack.setStatus(Rack.Status.valueOf(dto.getStatus().toUpperCase()));
            } catch (IllegalArgumentException e) {
                throw new WebApplicationException("Invalid rack status: " + dto.getStatus(), 400);
            }
        }

        rack.setTeamId(dto.getTeamId());
        rack.setDefaultLocation(dto.getDefaultLocation());
        rack.setModifiedAt(dto.getModifiedAt());

        return rack;
    }
}

