package com.frankmoley.lil.learningspring.webservice;

import java.util.Date;
import java.util.List;

import com.frankmoley.lil.learningspring.business.ReservationService;
import com.frankmoley.lil.learningspring.business.RoomReservation;
import com.frankmoley.lil.learningspring.data.Guest;
import com.frankmoley.lil.learningspring.data.Room;
import com.frankmoley.lil.learningspring.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WebserviceController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public WebserviceController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(path="/reservations", method = RequestMethod.GET)
    public List<RoomReservation> getReservations(@RequestParam(value="date", required = false)String dateString){
        Date date = this.dateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @RequestMapping(path="/rooms", method = RequestMethod.GET)
    public List<Room> getRooms(){
        List<Room> rooms = this.reservationService.getRooms();
        return rooms;
    }

    @RequestMapping(path = "/guests", method = RequestMethod.GET)
    public List<Guest> getGuests() {
        List<Guest> guests = this.reservationService.getGuests();
        return guests;
    }

    @PostMapping("/guests")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Guest saveGuest(@RequestBody Guest guest) {
        this.reservationService.saveGuest(guest);
        return guest;
    }
}
