package com.example.reservation.Service;

import com.example.reservation.Model.Flight;
import com.example.reservation.Model.SeatMap;
import com.example.reservation.Repository.FlightRepository;
import com.example.reservation.Repository.SeatMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    private FlightRepository flightRepository;
    private SeatMapRepository seatMapRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository,
                         SeatMapRepository seatMapRepository){
        this.flightRepository = flightRepository;
        this.seatMapRepository = seatMapRepository;
    }

    public synchronized Flight create(Flight flight){
        flightRepository.save(flight);
        SeatMap seatMap = new SeatMap();
        seatMap.setFlightNumber(flight.getFlightNumber());
        seatMapRepository.save(seatMap);
        return flight;
    }

    public synchronized SeatMap getSeatMap(Integer flightNumber){
        return seatMapRepository.findByFlightNumber(flightNumber);
    }

}
