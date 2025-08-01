
package com.ctw.workstation.rack.boundary;
import com.ctw.workstation.rack.entity.RackMapper;
import com.ctw.workstation.rack.control.RackRepository;
import com.ctw.workstation.rack.entity.RackDTO;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import com.ctw.workstation.rack.entity.Rack;
import jakarta.ws.rs.core.Response;

import java.util.*;
import java.util.stream.Collectors;

@Path("workstation/racks")
@Transactional
public class RackResource {

    @Inject
    RackRepository rackRepository;

    @POST
    public Response createRack(RackDTO dto){
// //ANTES DO DTO. FUNCIONAVA (a receber Rack rack por parametro)
//        rackRepository.persist(rack);
//        rackRepository.flush();
//        return Response.status(Response.Status.CREATED)
//                .entity(rack)
//                .build();

        Rack rack = RackMapper.INSTANCE.toEntity(dto);
        rackRepository.persist(rack);
        rackRepository.flush();
        return Response.status(Response.Status.CREATED)
                .entity(RackMapper.INSTANCE.toDTO(rack))
                .build();
    }

    @GET
    public Response getRacks(){
        List<RackDTO> dtos = rackRepository.listAll().stream()
                .map(RackMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
        return Response.ok(dtos).build();
        // Before DTO
        //return Response.ok(rackRepository.listAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getRack(@PathParam("id") UUID id) {
        Rack rack = rackRepository.findById(id);
        if (rack == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(RackMapper.INSTANCE.toDTO(rack)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateRack(@PathParam("id") UUID id, RackDTO dto){
        Rack existing = rackRepository.findById(id);
        if (existing == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        existing.setSerialNumber(dto.getSerialNumber());
        existing.setStatus(Rack.Status.valueOf(dto.getStatus()));
        existing.setTeamId(dto.getTeamId());
        existing.setDefaultLocation(dto.getDefaultLocation());
        existing.setModifiedAt(dto.getModifiedAt());

        return Response.ok(RackMapper.INSTANCE.toDTO(existing)).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteRack(@PathParam("id") UUID id){
        Rack rack = rackRepository.findById(id);
        if (rack == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        rackRepository.delete(rack);
        return Response.noContent().build();
        //Before DTO //return Response.ok(rackRepository.deleteById(id)).build();
    }

}

