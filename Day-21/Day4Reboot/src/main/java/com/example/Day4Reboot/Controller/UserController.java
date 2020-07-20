package com.example.Day4Reboot.Controller;

import com.example.Day4Reboot.Model.User;
import com.example.Day4Reboot.Request.AuthRequest;
import com.example.Day4Reboot.Request.LoginRequest;
import com.example.Day4Reboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody User user){
        return userService.create(user);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        return userService.login(loginRequest);
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.POST)
    public ResponseEntity<?> getUser(@RequestBody AuthRequest authRequest, @PathVariable Integer id){
        return userService.getUser(authRequest,id);
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody User user,@RequestParam Integer id){
        return userService.update(user,id);
    }

    @RequestMapping(value = "/search/{username}")
    public ResponseEntity<?> searchByName(@PathVariable String username){
        return userService.searchByName(username);
    }

}
