package com.example.reservation.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Flight {
    @Id
    private Integer flightNumber;
    private String origin;
    private String destination;
    private Integer seats;
    private String departure;
    private String arrival;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(referencedColumnName = "flightNumber")
//    private SeatMap seatMap;

//    public SeatMap getSeatMap() {
//        return seatMap;
//    }
    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

//    public void setSeatMap(SeatMap seatMap) {
//        this.seatMap = seatMap;
//    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

}
