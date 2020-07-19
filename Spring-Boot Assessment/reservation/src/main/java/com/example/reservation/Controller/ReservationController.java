package com.example.reservation.Controller;

import com.example.reservation.Model.Reservation;
import com.example.reservation.Request.ReservationRequest;
import com.example.reservation.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @RequestMapping(value = "/reserve", method = RequestMethod.POST)
    public ResponseEntity<?> reserve(@RequestBody ReservationRequest reservationRequest){
        return reservationService.reserve(reservationRequest);
    }

    @RequestMapping(value = "/cancel/{resId}",method = RequestMethod.GET)
    public ResponseEntity<?> cancel(@PathVariable Integer resId){
        return reservationService.cancel(resId);
    }

}
