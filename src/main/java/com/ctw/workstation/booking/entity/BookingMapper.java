package com.ctw.workstation.booking.entity;

import com.ctw.workstation.rackasset.entity.RackAsset;
import com.ctw.workstation.rackasset.entity.RackAssetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.UUID;

@Mapper(componentModel = "cdi")
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    default BookingDTO toDTO(Booking booking) {
        if (booking == null) return null;

        return new BookingDTO(
                booking.getId(),
                booking.getRackId(),
                booking.getTeamMemberId(),
                booking.getSerialNumber(),
                booking.getBookFrom(),
                booking.getBookTo(),
                booking.getCreatedAt(),
                booking.getModifiedAt()
        );
    }

    @Mapping(target = "rack", ignore = true)
    Booking toEntity(BookingDTO dto) ;
}
