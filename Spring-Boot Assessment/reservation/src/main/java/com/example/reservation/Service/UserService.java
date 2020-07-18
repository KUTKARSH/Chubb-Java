package com.example.reservation.Service;

import com.example.reservation.Model.Reservation;
import com.example.reservation.Model.User;
import com.example.reservation.Repository.ReservationRepository;
import com.example.reservation.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private ReservationRepository reservationRepository;

    @Autowired
    public UserService(UserRepository userRepository,
                       ReservationRepository reservationRepository){
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
    }

    public synchronized User registerUser(User user){
        userRepository.save(user);
        return user;
    }

    public List<Reservation> getReservationsByUser(Integer id){
        List<Reservation> reservations = reservationRepository.findAllByUserId(id);
        return reservations;
    }

    public List<User> getClients(Integer agentId){
        return userRepository.findAllByAgentId(agentId);
    }
}
