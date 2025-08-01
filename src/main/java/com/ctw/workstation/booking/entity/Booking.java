package com.ctw.workstation.booking.entity;


import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.teammember.entity.TeamMember;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "T_BOOKING")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "rack_id", nullable = false)
    private UUID rackId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rack_id", insertable=false, updatable=false)
    private Rack rack;
    @Column(name = "requester_id", nullable = false)
    private UUID teamMemberId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requester_id", insertable=false, updatable=false)
    private TeamMember teamMember;
    @Column(name = "serial_number")
    private String serialNumber;
    @Column(name = "book_from")
    private Date bookFrom;
    @Column(name = "book_to")
    private Date bookTo;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "modified_at")
    private Date modifiedAt;

    public Booking() {
    }

    public Booking(UUID id, Rack rack, TeamMember teamMember, String serialNumber, Date bookFrom, Date bookTo, Date createdAt, Date modifiedAt) {
        this.id = id;
        this.rack = rack;
        this.teamMember = teamMember;
        this.serialNumber = serialNumber;
        this.bookFrom = bookFrom;
        this.bookTo = bookTo;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(TeamMember teamMember) {
        this.teamMember = teamMember;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getBookFrom() {
        return bookFrom;
    }

    public void setBookFrom(Date bookFrom) {
        this.bookFrom = bookFrom;
    }

    public Date getBookTo() {
        return bookTo;
    }

    public void setBookTo(Date bookTo) {
        this.bookTo = bookTo;
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

    public UUID getRackId() {
        return rackId;
    }

    public void setRackId(UUID rackId) {
        this.rackId = rackId;
    }

    public UUID getTeamMemberId() {
        return teamMemberId;
    }

    public void setTeamMemberId(UUID teamMemberId) {
        this.teamMemberId = teamMemberId;
    }
}
