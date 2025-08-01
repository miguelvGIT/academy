package com.ctw.workstation.rackasset.entity;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "cdi")
public interface RackAssetMapper {
    RackAssetMapper INSTANCE = Mappers.getMapper(RackAssetMapper.class);

    default RackAssetDTO toDTO(RackAsset rackAsset) {
        if (rackAsset == null) return null;

        return new RackAssetDTO(
                rackAsset.getId(),
                rackAsset.getAssetTag(),
                rackAsset.getRackId()
        );
    }

    @Mapping(target = "rack", ignore = true)
    RackAsset toEntity(RackAssetDTO dto) ;
//    {
//        if (dto == null) return null;
//
//        RackAsset rackAsset = new RackAsset();
//
//        rackAsset.setAssetTag(dto.getAssetTag());
//        rackAsset.setRackId(dto.getRackId());
//        rackAsset.setId(dto.getId());
//
//        return rackAsset;
//    }
}
