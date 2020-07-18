package com.example.reservation.Repository;

import com.example.reservation.Model.Flight;
import com.example.reservation.Model.SeatMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface SeatMapRepository extends JpaRepository<SeatMap, Flight> {
    public SeatMap findByFlightNumber(Integer flightNumber);
}
