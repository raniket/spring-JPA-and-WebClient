package com.frankmoley.lil.learningspring.util;

import java.util.Date;
import java.util.List;

import com.frankmoley.lil.learningspring.business.ReservationService;
import com.frankmoley.lil.learningspring.business.RoomReservation;
import com.frankmoley.lil.learningspring.business.TodoService;
import com.frankmoley.lil.learningspring.data.Todo;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final ReservationService reservationService;
    private final DateUtils dateUtils;
    private final TodoService todoService;

    public AppStartupEvent(
            ReservationService reservationService,
            DateUtils dateUtils,
            TodoService todoService
    ) {
        this.reservationService = reservationService;
        this.dateUtils = dateUtils;
        this.todoService = todoService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Date date = this.dateUtils.createDateFromDateString("2022-01-01");
        List<RoomReservation> reservations = this.reservationService.getRoomReservationsForDate(date);
//        reservations.forEach(System.out::println);

        System.out.println("Printing todos.................");
        String todos = this.todoService.getTodos();
        System.out.println(todos);
    }
}
