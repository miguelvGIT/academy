package com.ctw.workstation.rack.entity;

import com.ctw.workstation.team.entity.Team;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

public class RackDTO {
    private UUID id;
    private String serialNumber;
    private String status;
    private UUID teamId;
    private String defaultLocation;
    private Date modifiedAt;

    // Constructors
    public RackDTO() {
    }

    public RackDTO(UUID id, String serialNumber, String status, UUID teamId, String defaultLocation, Date modifiedAt) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.status = status;
        this.teamId = teamId;
        this.defaultLocation = defaultLocation;
        this.modifiedAt = modifiedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public void setTeamId(UUID teamId) {
        this.teamId = teamId;
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}