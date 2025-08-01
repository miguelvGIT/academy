package com.ctw.workstation.teammember.entity;

import com.ctw.workstation.team.entity.Team;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;
import java.util.UUID;

public class TeamMemberDTO {
    private UUID id;
    private UUID teamId;
    private String ctwId;
    private String name;
    private Date modifiedAt;

    public TeamMemberDTO() {
    }

    public TeamMemberDTO(UUID id, UUID teamId, String ctwId, String name, Date modifiedAt) {
        this.id = id;
        this.teamId = teamId;
        this.ctwId = ctwId;
        this.name = name;
        this.modifiedAt = modifiedAt;
    }

    public UUID getId() {
        return id;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public String getCtwId() {
        return ctwId;
    }

    public String getName() {
        return name;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTeamId(UUID teamId) {
        this.teamId = teamId;
    }

    public void setCtwId(String ctwId) {
        this.ctwId = ctwId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}


