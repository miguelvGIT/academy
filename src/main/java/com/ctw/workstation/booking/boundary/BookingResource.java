package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.booking.control.BookingRepository;
import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.booking.entity.BookingDTO;
import com.ctw.workstation.booking.entity.BookingMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Path("/workstation/Bookings")
@Transactional
public class BookingResource{

    private static final Logger log = Logger.getLogger(BookingResource.class);


    @Inject
    BookingRepository bookingRepository;

    @POST
    public Response createBooking(BookingDTO dto){
        Booking booking = BookingMapper.INSTANCE.toEntity(dto);
        bookingRepository.persist(booking);
        bookingRepository.flush();
        return Response.status(Response.Status.CREATED)
                .entity(BookingMapper.INSTANCE.toDTO(booking))
                .build();
    }

    @GET
    public Response getBookings(){

        /*MOC.put("trace")*/


        List<BookingDTO> dtos = bookingRepository.listAll().stream()
                .map(BookingMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
        return Response.ok(dtos).build();
        // Before DTO
        //return Response.ok(rackRepository.listAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getBooking(@PathParam("id") UUID id) {
        /*MOC.put("traceId", UUID.randomUUID());*/

        log.debug("Get booking with id " + id);
        log.debug("Get booking with id %s" .formatted(id));

        Booking booking = bookingRepository.findById(id);
        if (booking == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(BookingMapper.INSTANCE.toDTO(booking)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateBooking(@PathParam("id") UUID id, BookingDTO dto){
        Booking existing = bookingRepository.findById(id);
        if (existing == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        existing.setSerialNumber(dto.getSerialNumber());
        existing.setBookFrom(dto.getBookFrom());
        existing.setBookTo(dto.getBookTo());
        existing.setCreatedAt(existing.getCreatedAt());
        existing.setModifiedAt(existing.getModifiedAt());

        return Response.ok(BookingMapper.INSTANCE.toDTO(existing)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBooking(@PathParam("id") UUID id){
        Booking booking = bookingRepository.findById(id);
        if (booking == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        bookingRepository.delete(booking);
        return Response.noContent().build();
        //Before DTO //return Response.ok(rackRepository.deleteById(id)).build();
    }
}
