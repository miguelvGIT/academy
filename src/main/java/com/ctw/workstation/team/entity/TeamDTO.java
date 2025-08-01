package com.ctw.workstation.team.entity;

import jakarta.persistence.Column;

import java.util.Date;
import java.util.UUID;

public record TeamDTO (
     UUID id,
     String name,
     String product,
     Date createdAt,
     Date modifiedAt,
     String defaultLocation
){

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProduct() {
        return product;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }
}



