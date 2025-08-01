package com.ctw.workstation.team.boundary;

import com.ctw.workstation.team.entity.TeamMapper;
import com.ctw.workstation.team.control.TeamRepository;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamDTO;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Path("workstation/teams")
@Transactional
public class TeamResource {

    @Inject
    TeamRepository teamRepository;

    @POST
    public Response createTeam(TeamDTO dto){

        /*teamRepository.persist(team);

        teamRepository.flush();


        return Response.status(Response.Status.CREATED)
                .entity(team)
                .build();*/

        Team team = TeamMapper.INSTANCE.toEntity(dto);
        teamRepository.persist(team);
        teamRepository.flush();
        return Response.status(Response.Status.CREATED)
                .entity(TeamMapper.INSTANCE.toDTO(team))
                .build();
    }

    @GET
    public Response getTeams(){
        List<Team> dtos = teamRepository.listAll();
        return Response.ok(dtos).build();
        // Before DTO
        //return Response.ok(rackRepository.listAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getTeam(@PathParam("id") UUID id) {
        Team team = teamRepository.findById(id);
        if (team == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(TeamMapper.INSTANCE.toDTO(team)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTeam(@PathParam("id") UUID id, TeamDTO dto){
        Team existing = teamRepository.findById(id);
        if (existing == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        existing.setName(dto.getName());
        existing.setProduct(dto.getProduct());
        existing.setCreatedAt(dto.getCreatedAt());
        existing.setDefaultLocation(dto.getDefaultLocation());
        existing.setModifiedAt(dto.getModifiedAt());

        return Response.ok(TeamMapper.INSTANCE.toDTO(existing)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTeam(@PathParam("id") UUID id){
        Team team = teamRepository.findById(id);
        if (team == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        teamRepository.delete(team);
        return Response.noContent().build();
        //Before DTO //return Response.ok(rackRepository.deleteById(id)).build();
    }
}