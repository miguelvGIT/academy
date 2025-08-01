package com.ctw.workstation.rack.entity;

import com.ctw.workstation.team.entity.Team;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "t_rack")
public class Rack {
    public enum Status {
        AVAILABLE,
        BOOKED,
        UNAVAILABLE;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;


    @Column(name = "serial_number", length = 10, nullable = false, unique = true)
    private String serialNumber;


    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;


    @Column(name = "team_id", nullable = false)
    private UUID teamId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false, insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Team team;

    @Column(name = "default_location", length = 30)
    private String defaultLocation;


    @Column(name = "modified_at")
    private Date modifiedAt;

    public Rack() {
    }

    public Rack(UUID id, String serialNumber, Status status, Team team, String defaultLocation, Date modifiedAt) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.status = status;
        this.team = team;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public void setTeamId(UUID teamId) {
        this.teamId = teamId;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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


