package com.example.reservation.Repository;

import com.example.reservation.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByUserId(Integer userId);
    public List<User> findAllByAgentId(Integer id);
}
