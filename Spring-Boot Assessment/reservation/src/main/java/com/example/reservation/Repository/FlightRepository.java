package com.example.reservation.Repository;

import com.example.reservation.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface FlightRepository extends JpaRepository<Flight,Integer> {
    public Flight findByFlightNumber(Integer flightNumber);

}
