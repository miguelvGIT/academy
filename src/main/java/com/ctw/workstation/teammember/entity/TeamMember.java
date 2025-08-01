package com.ctw.workstation.teammember.entity;

import com.ctw.workstation.team.entity.Team;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "T_TEAM_MEMBER")
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID, generator = "teamMemberIdGenerator")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;
    @Column(name = "team_id", nullable = false)
    private UUID teamId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false, insertable=false, updatable=false)
    private Team team;
    @Column(name = "ctw_id", length = 7, nullable = false)
    private String ctwId;
    @Column(name = "name", length = 20)
    private String name;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "modified_at")
    private Date modifiedAt;

    public TeamMember() {
    }

    public TeamMember(UUID id, UUID teamId, Team team, String ctwId, String name, Date createdAt, Date modifiedAt) {
        this.id = id;
        this.teamId = teamId;
        this.team = team;
        this.ctwId = ctwId;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getCtwId() {
        return ctwId;
    }

    public void setCtwId(String ctwId) {
        this.ctwId = ctwId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
