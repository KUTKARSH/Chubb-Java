package com.example.Day4Reboot.controller;

import com.example.Day4Reboot.model.User;
import com.example.Day4Reboot.request.AuthRequest;
import com.example.Day4Reboot.request.LoginRequest;
import com.example.Day4Reboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody User user){
        return userServiceImpl.create(user);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        return userServiceImpl.login(loginRequest);
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.POST)
    public ResponseEntity<?> getUser(@RequestBody AuthRequest authRequest, @PathVariable Integer id){
        return userServiceImpl.getUser(authRequest,id);
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody User user,@RequestParam Integer id){
        return userServiceImpl.update(user,id);
    }

    @RequestMapping(value = "/search/{username}")
    public ResponseEntity<?> searchByName(@PathVariable String username){
        return userServiceImpl.searchByName(username);
    }

}
