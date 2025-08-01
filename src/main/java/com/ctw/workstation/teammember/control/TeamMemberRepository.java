package com.ctw.workstation.teammember.control;

import com.ctw.workstation.teammember.entity.TeamMember;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class TeamMemberRepository implements PanacheRepositoryBase<TeamMember, UUID> {

}
