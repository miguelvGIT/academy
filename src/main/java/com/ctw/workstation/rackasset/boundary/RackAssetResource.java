package com.ctw.workstation.rackasset.boundary;

import com.ctw.workstation.rackasset.entity.RackAssetMapper;
import com.ctw.workstation.rackasset.control.RackAssetRepository;
import com.ctw.workstation.rackasset.entity.RackAsset;
import com.ctw.workstation.rackasset.entity.RackAssetDTO;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Path("/workstation/RackAssets")
@Transactional
public class RackAssetResource {

    private static final Logger log = Logger.getLogger(RackAssetResource.class);


    @Inject
    RackAssetRepository rackAssetRepository;

    @POST
    public Response createRackAsset(RackAssetDTO dto){
// //ANTES DO DTO. FUNCIONAVA (a receber Rack rack por parametro)
//        rackRepository.persist(rack);
//        rackRepository.flush();
//        return Response.status(Response.Status.CREATED)
//                .entity(rack)
//                .build();


        RackAsset rackAsset = RackAssetMapper.INSTANCE.toEntity(dto);
        rackAssetRepository.persist(rackAsset);
        rackAssetRepository.flush();
        return Response.status(Response.Status.CREATED)
                .entity(RackAssetMapper.INSTANCE.toDTO(rackAsset))
                .build();
    }

    @GET
    public Response getRackAssets(){
        List<RackAssetDTO> dtos = rackAssetRepository.listAll().stream()
                .map(RackAssetMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
        return Response.ok(dtos).build();
        // Before DTO
        //return Response.ok(rackRepository.listAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getRackAsset(@PathParam("id") UUID id) {
        RackAsset rackAsset = rackAssetRepository.findById(id);
        if (rackAsset == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(RackAssetMapper.INSTANCE.toDTO(rackAsset)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateRackAsset(@PathParam("id") UUID id, RackAssetDTO dto){
        RackAsset existing = rackAssetRepository.findById(id);
        if (existing == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        existing.setAssetTag(dto.getAssetTag());

        return Response.ok(RackAssetMapper.INSTANCE.toDTO(existing)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRackAsset(@PathParam("id") UUID id){
        RackAsset rackAsset = rackAssetRepository.findById(id);
        if (rackAsset == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        rackAssetRepository.delete(rackAsset);
        return Response.noContent().build();
        //Before DTO //return Response.ok(rackRepository.deleteById(id)).build();
    }
}
