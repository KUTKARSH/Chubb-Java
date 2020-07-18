package com.example.reservation.Controller;

import com.example.reservation.Model.Flight;
import com.example.reservation.Model.SeatMap;
import com.example.reservation.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService){
        this.flightService = flightService;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public Flight create(@RequestBody Flight flight){
        return flightService.create(flight);
    }

    @RequestMapping(value = "/getMap/{flightNumber}",method = RequestMethod.GET)
    public SeatMap getSeatMap(@PathVariable Integer flightNumber){
        return flightService.getSeatMap(flightNumber);
    }
}
