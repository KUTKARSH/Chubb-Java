package com.example.Day4Reboot.service;

import com.example.Day4Reboot.model.User;
import com.example.Day4Reboot.repository.UserRepository;
import com.example.Day4Reboot.request.AuthRequest;
import com.example.Day4Reboot.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<?> create(User user){
        if(user.getEmail() == null || user.getUserName() == null || user.getPassword() == null)
            return new ResponseEntity<>("Username/email/password is missing", HttpStatus.BAD_REQUEST);
        User searchedUser = userRepository.findByUserName(user.getUserName());
        if(searchedUser != null)
            return new ResponseEntity<>("User already exists.",HttpStatus.NOT_ACCEPTABLE);
        userRepository.save(user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> login(LoginRequest loginRequest){
        User searchedUser = userRepository.findByUserName(loginRequest.getUserName());
        if(searchedUser == null)
            return new ResponseEntity<>("User doesn't exist",HttpStatus.UNAUTHORIZED);
        if(!loginRequest.getUserName().equals(searchedUser.getUserName()))
            return new ResponseEntity<>("Username incorrect",HttpStatus.UNAUTHORIZED);
        if(!loginRequest.getPassword().equals(searchedUser.getPassword()))
            return new ResponseEntity<>("Password incorrect",HttpStatus.UNAUTHORIZED  );
        return new ResponseEntity<>("Login successful !" ,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getUser(AuthRequest authRequest, Integer id){
        User searchedUser = userRepository.findByUserName(authRequest.getUserName());
        if(searchedUser.getId() != id)
            return new ResponseEntity<>("Can't fetch other's details",HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(searchedUser,HttpStatus.OK);
    }

    User mapAttributes(User newUser,User oldUser){
        oldUser.setEmail(newUser.getEmail());
        oldUser.setFirstName(newUser.getFirstName());
        oldUser.setLastName(newUser.getLastName());
        oldUser.setPassword(newUser.getPassword());
        return oldUser;
    }

    @Override
    public ResponseEntity<?> update(User user,Integer id){
        if(user.getEmail() == null || user.getUserName() == null || user.getPassword() == null)
            return new ResponseEntity<>("Username/email/password is missing", HttpStatus.BAD_REQUEST);

        User searchedUser = userRepository.findByUserName(user.getUserName());
        if(searchedUser.getId() != id)
            return new ResponseEntity<>("Can't fetch other's details",HttpStatus.BAD_REQUEST);
        searchedUser = mapAttributes(user,searchedUser);
        userRepository.save(searchedUser);
        return new ResponseEntity<>("User details updated",HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<?> searchByName(String username){
        User searchedUser = userRepository.findByUserName(username);
        if(searchedUser == null)
            return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(searchedUser,HttpStatus.FOUND);
    }
}
