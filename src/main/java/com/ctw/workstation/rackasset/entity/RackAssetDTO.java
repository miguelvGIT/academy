package com.ctw.workstation.rackasset.entity;

import java.util.UUID;

public record RackAssetDTO(
        UUID id,
        String assetTag,
        UUID rackId
) {

    public UUID getRackId() {
        return rackId;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public UUID getId() {
        return id;
    }

}
