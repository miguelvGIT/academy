package com.ctw.workstation.team.entity;

import com.ctw.workstation.rack.entity.Rack;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "T_TEAM")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "product")
    private String product;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "modified_at")
    private Date modifiedAt;
    @Column(name = "default_location", length = 10)
    private String defaultLocation;

    /*@JsonIgnore()
    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<Rack> rack;*/

    public Team() {
    }

    public Team(UUID id, String name, String product, Date createdAt, Date modifiedAt, String defaultLocation) {
        this.id = id;
        this.name = name;
        this.product = product;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.defaultLocation = defaultLocation;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
