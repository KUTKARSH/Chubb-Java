package com.example.Day4Reboot.repository;

import com.example.Day4Reboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByUserName(String username);
//    public User findById(Integer id);
}
