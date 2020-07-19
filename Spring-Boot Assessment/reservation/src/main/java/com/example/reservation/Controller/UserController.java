package com.example.reservation.Controller;

import com.example.reservation.Model.Reservation;
import com.example.reservation.Model.User;
import com.example.reservation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody User details){
        if(details.getEmail() == null || details.getEmail().isEmpty() || details.getEmail().equals(null))
            return new ResponseEntity<>("Email mandatory", HttpStatus.BAD_REQUEST);
        return userService.registerUser(details);
    }

    @RequestMapping(value = "/getReservations/{id}")
    public List<Reservation> getReservationsByUser(@PathVariable Integer id){
        return userService.getReservationsByUser(id);
    }

    @RequestMapping(value = "/getClients/{userId}")
    public List<User> getClients(@PathVariable Integer userId){
        return userService.getClients(userId);
    }

}
