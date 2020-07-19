package com.example.reservation.Service;

import com.example.reservation.Model.Flight;
import com.example.reservation.Model.Reservation;
import com.example.reservation.Model.SeatMap;
import com.example.reservation.Model.User;
import com.example.reservation.Repository.FlightRepository;
import com.example.reservation.Repository.ReservationRepository;
import com.example.reservation.Repository.SeatMapRepository;
import com.example.reservation.Repository.UserRepository;
import com.example.reservation.Request.ReservationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;
    private UserRepository userRepository;
    private FlightRepository flightRepository;
    private SeatMapRepository seatMapRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository,
                              UserRepository userRepository,
                              FlightRepository flightRepository,
                              SeatMapRepository seatMapRepository){
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.flightRepository = flightRepository;
        this.seatMapRepository = seatMapRepository;
    }

    public User registerUser(Integer agentId){
        User user = new User();
        user.setEmail("unregisteredUser@gmail.com");
        user.setRole("user");
        user.setAgentId(agentId);
        return userRepository.save(user);
    }

    public synchronized ResponseEntity<?> reserve(ReservationRequest reservationRequest){
        User user = userRepository.findByUserId(reservationRequest.getUserId());
        Flight flight = flightRepository.findByFlightNumber(reservationRequest.getFlightNumber());
        if(flight == null)
            return new ResponseEntity<>("No such flight exists", HttpStatus.BAD_GATEWAY);
        if(user == null)
            user = registerUser(reservationRequest.getAgentId());
        Reservation reservation = new Reservation();
        reservation.setUserId(user.getUserId());
        reservation.setFlightNumber(flight.getFlightNumber());
        reservation.setSeatNo(reservationRequest.getSeatNo());
        if(reservationRequest.getAgentId() != null)
        {
            reservation.setAgentId(reservationRequest.getAgentId());
            user.setAgentId(reservationRequest.getAgentId());
        }
        SeatMap seatMap = seatMapRepository.findByFlightNumber(flight.getFlightNumber());
        switch (reservationRequest.getSeatNo()){
            case 1 : if(!seatMap.getRow1())
                        seatMap.setRow1(true);
                    else
                        return new ResponseEntity<>("Seat already booked !!",HttpStatus.BAD_REQUEST);
                    break;
            case 2 : if(!seatMap.getRow2())
                seatMap.setRow2(true);
            else
                return new ResponseEntity<>("Seat already booked !!",HttpStatus.BAD_REQUEST);
            break;
            case 3 : if(!seatMap.getRow3())
                seatMap.setRow3(true);
            else
                return new ResponseEntity<>("Seat already booked !!",HttpStatus.BAD_REQUEST);
            break;
            case 4 : if(!seatMap.getRow4())
                seatMap.setRow4(true);
            else
                return new ResponseEntity<>("Seat already booked !!",HttpStatus.BAD_REQUEST);
            break;
            case 5 : if(!seatMap.getRow5())
                seatMap.setRow5(true);
            else
                return new ResponseEntity<>("Seat already booked !!",HttpStatus.BAD_REQUEST);
            break;
        }
        userRepository.save(user);
        seatMapRepository.save(seatMap);
        reservationRepository.save(reservation);
        return new ResponseEntity<>(reservation,HttpStatus.OK);
    }

    public ResponseEntity<?> cancel(Integer resId){
        Reservation reservation = reservationRepository.findByResId(resId);
        Integer flightNumber = reservation.getFlightNumber();
        SeatMap seatMap = seatMapRepository.findByFlightNumber(flightNumber);
        switch (reservation.getSeatNo()){
            case 1 : seatMap.setRow1(false);
                    break;
            case 2 : seatMap.setRow2(false);
                break;
            case 3 : seatMap.setRow3(false);
                break;
            case 4 : seatMap.setRow4(false);
                break;
            case 5 : seatMap.setRow5(false);
                break;
        }
        seatMapRepository.save(seatMap);
        reservationRepository.delete(reservation);
        return new ResponseEntity<>("Reservation cancelled & seat vacated",HttpStatus.OK);
    }

}
