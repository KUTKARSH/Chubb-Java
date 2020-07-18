package com.example.reservation.Model;

import javax.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private Integer resId;

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    //    @ManyToOne(fetch = FetchType.LAZY)
    private Integer flightNumber;
    private Integer seatNo;
//    @ManyToOne(fetch = FetchType.LAZY)
    private Integer userId;
//    @ManyToOne(fetch = FetchType.LAZY)
    private Integer agentId;

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public Integer getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(Integer seatNo) {
        this.seatNo = seatNo;
    }




}
