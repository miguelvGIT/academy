package com.ctw.workstation.rack.control;

import com.ctw.workstation.rack.entity.Rack;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class RackRepository implements PanacheRepositoryBase<Rack, UUID> {


}
