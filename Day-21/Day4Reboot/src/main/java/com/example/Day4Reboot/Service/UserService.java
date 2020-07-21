package com.example.Day4Reboot.service;


import com.example.Day4Reboot.model.User;
import com.example.Day4Reboot.request.AuthRequest;
import com.example.Day4Reboot.request.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<?> create(User user);
    public ResponseEntity<?> login(LoginRequest loginRequest);
    public ResponseEntity<?> getUser(AuthRequest authRequest, Integer id);
    public ResponseEntity<?> update(User user,Integer id);
    public ResponseEntity<?> searchByName(String username);
}
