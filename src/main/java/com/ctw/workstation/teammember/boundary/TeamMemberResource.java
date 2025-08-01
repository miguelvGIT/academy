package com.ctw.workstation.teammember.boundary;

import com.ctw.workstation.teammember.control.TeamMemberRepository;
import com.ctw.workstation.teammember.entity.TeamMember;
import com.ctw.workstation.teammember.entity.TeamMemberDTO;
import com.ctw.workstation.teammember.entity.TeamMemberMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Path("/workstation/TeamMembers")
@Transactional
public class TeamMemberResource {

    @Inject
    TeamMemberRepository teamMemberRepository;

    @POST
    public Response createTeamMember(TeamMemberDTO dto){
        TeamMember teamMember = TeamMemberMapper.INSTANCE.toEntity(dto);
        teamMemberRepository.persist(teamMember);
        teamMemberRepository.flush();
        return Response.status(Response.Status.CREATED)
                .entity(TeamMemberMapper.INSTANCE.toDTO(teamMember))
                .build();
    }

    @GET
    public Response getTeamMembers(){
        List<TeamMemberDTO> dtos = teamMemberRepository.listAll().stream()
                .map(TeamMemberMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
        return Response.ok(dtos).build();
        // Before DTO
        //return Response.ok(rackRepository.listAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getTeamMember(@PathParam("id") UUID id) {
        TeamMember teamMember = teamMemberRepository.findById(id);
        if (teamMember == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(TeamMemberMapper.INSTANCE.toDTO(teamMember)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTeamMember(@PathParam("id") UUID id, TeamMemberDTO dto){
        TeamMember existing = teamMemberRepository.findById(id);
        if (existing == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        existing.setTeamId(dto.getTeamId());
        existing.setCtwId(dto.getCtwId());
        existing.setName(dto.getName());
        existing.setModifiedAt(dto.getModifiedAt());


        return Response.ok(TeamMemberMapper.INSTANCE.toDTO(existing)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTeamMember(@PathParam("id") UUID id){
        TeamMember teamMember = teamMemberRepository.findById(id);
        if (teamMember == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        teamMemberRepository.delete(teamMember);
        return Response.noContent().build();
        //Before DTO //return Response.ok(rackRepository.deleteById(id)).build();
    }
}
