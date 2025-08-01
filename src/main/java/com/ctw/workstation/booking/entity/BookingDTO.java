package com.ctw.workstation.booking.entity;

import java.util.Date;
import java.util.UUID;

public record BookingDTO (

     UUID id,
     UUID rackId,
     UUID teamMemberId,
     String serialNumber,
     Date bookFrom,
     Date bookTo,
     Date createdAt,
     Date modifiedAt

){
    public UUID getId() {
        return id;
    }

    public UUID getRackId() {
        return rackId;
    }

    public UUID getTeamMemberId() {
        return teamMemberId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Date getBookFrom() {
        return bookFrom;
    }

    public Date getBookTo() {
        return bookTo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }
}
