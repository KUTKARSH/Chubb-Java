package com.example.reservation.Repository;

import com.example.reservation.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
    public Reservation findByResId(Integer id);
    public List<Reservation> findAllByUserId(Integer id);
}
