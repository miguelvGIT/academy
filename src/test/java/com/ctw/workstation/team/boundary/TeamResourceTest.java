package com.ctw.workstation.team.boundary;

import com.ctw.workstation.team.control.TeamRepository;
import com.ctw.workstation.team.entity.TeamDTO;
import com.ctw.workstation.team.entity.TeamMapper;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

public class TeamResourceTest {

    @QuarkusTest
    public static class TestResourceTest {

    }

    @InjectMock
    TeamRepository teamRepository;


    @Inject
    TeamResource teamResource; //Fizeram para o service, tudo o que use este teamResource deveria usar teamService

    @Inject
    TeamMapper teamMapper;

    @Test
    @DisplayName("Create team")
    public void create_team() {
        //given
       /* TeamRequest teamRequest = new TeamRequest("Commodore Amiga", "CTW academy");
        //when
        TeamDTO teamDTO = teamResource.createTeam(teamRequest);
        //then
        Assertions.assertThat(teamDTO)
                .isNotNull()
                .hasNoNullFieldsOrPropertiesExcept("id")
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(teamRequest);
        Mockito.verify(teamRepository).persist(persistedTeam);*/
    }
}
