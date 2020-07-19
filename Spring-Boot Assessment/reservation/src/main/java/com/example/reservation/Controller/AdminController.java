package com.example.reservation.Controller;

import com.example.reservation.Model.Reservation;
import com.example.reservation.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private ReservationRepository reservationRepository;

    @Autowired
    public AdminController(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    @RequestMapping(value = "/getAllReservations", method = RequestMethod.GET)
    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }
}
