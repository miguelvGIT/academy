package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.booking.entity.BookingDTO;
import com.ctw.workstation.booking.entity.BookingMapper;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.entity.RackDTO;
import com.ctw.workstation.simple.ExternalMessageService;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamDTO;
import com.ctw.workstation.teammember.entity.TeamMember;
import com.ctw.workstation.teammember.entity.TeamMemberDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import jakarta.ws.rs.ApplicationPath;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.jboss.resteasy.reactive.RestPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@ApplicationPath("/workstation/")
@ExtendWith(MockitoExtension.class)
class BookingResourceTest {

    Team team;
    Rack rack;
    TeamMember teamMember;
    Booking booking;

    @Spy
    BookingMapper bookingMapperSpy;

    @BeforeAll
    static void beforeAll() {

    }

    @BeforeEach
    void setup() {
        /*TeamDTO team = new TeamDTO(
                UUID.randomUUID(),
                "Team JUNIT",
                "MINI ONE",
                new Date(),
                new Date(),
                "Lisbon"
        );*/

        team = new Team();
        team.setName("testTeam");
        team.setProduct("testProduct");
        team.setCreatedAt(new Date());
        team.setModifiedAt(new Date());
        team.setDefaultLocation("Lisbon");

        /*RackDTO rack = new RackDTO(
                UUID.randomUUID(),
                "1000-245-02",
                "BOOKED",
                team.getId(),
                "Lisbon",
                new Date() //LocalDateTime.now()

        );*/

        rack = new Rack();
        rack.setSerialNumber("1000-200-03");
        rack.setStatus(Rack.Status.BOOKED);
        rack.setTeamId(team.getId());
        rack.setTeam(team);
        rack.setDefaultLocation("Lisbon");
        rack.setModifiedAt(new Date());

        teamMember = new TeamMember();
        teamMember.setTeamId(team.getId());
        teamMember.setTeam(team);
        teamMember.setCtwId("ctw04439");
        teamMember.setName("testTeamMember");
        teamMember.setCreatedAt(new Date());
        teamMember.setModifiedAt(new Date());

        booking = new Booking();
        booking.setRackId(rack.getId());
        booking.setTeamMemberId(teamMember.getId());
        booking.setRack(rack);
        booking.setTeamMember(teamMember);
        booking.setSerialNumber("1000-200-03");
        booking.setCreatedAt(new Date());
        booking.setModifiedAt(new Date());
        booking.setBookFrom(new Date());
        booking.setBookTo(new Date());
    }

    @Test
    @DisplayName("Create Booking")
    void create_booking(){
        //given
        //when
        //then
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(booking)
                .when()
                .post("Bookings")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .log();
            /*    .all()


        Assertions.assertThat()
                .*/
    }

    @Test
    @DisplayName("Get Bookings")
    void when_getting_bookings(){
        //given

        //when
        //then
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/Bookings")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }


}