package com.ctw.workstation.rackasset.entity;

import com.ctw.workstation.rack.entity.Rack;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "T_RACK_ASSET")
public class RackAsset {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID, generator = "rack_assetIdGenerator")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;
    @Column(name = "asset_tag", length = 10)
    private String assetTag;
    @Column(name = "rack_id", nullable = false)
    private UUID rackId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rack_id", nullable = false, insertable=false, updatable=false)
    private Rack rack;

    public RackAsset() {
    }

    public RackAsset(UUID id, String assetTag, Rack rack, UUID rackId) {
        this.id = id;
        this.assetTag = assetTag;
        this.rack = rack;
        this.rackId = rackId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    public UUID getRackId() {
        return rackId;
    }

    public void setRackId(UUID rackId) {
        this.rackId = rackId;
    }
}
