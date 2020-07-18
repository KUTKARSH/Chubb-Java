package com.example.reservation.Model;

import javax.persistence.*;

@Entity
public class SeatMap {

    @Id
    private Integer flightNumber;

    private Boolean row1 = false;
    private Boolean row2 = false;
    private Boolean row3 = false;
    private Boolean row4 = false;
    private Boolean row5 = false;

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Boolean getRow1() {
        return row1;
    }

    public void setRow1(Boolean row1) {
        this.row1 = row1;
    }

    public Boolean getRow2() {
        return row2;
    }

    public void setRow2(Boolean row2) {
        this.row2 = row2;
    }

    public Boolean getRow3() {
        return row3;
    }

    public void setRow3(Boolean row3) {
        this.row3 = row3;
    }

    public Boolean getRow4() {
        return row4;
    }

    public void setRow4(Boolean row4) {
        this.row4 = row4;
    }

    public Boolean getRow5() {
        return row5;
    }

    public void setRow5(Boolean row5) {
        this.row5 = row5;
    }


}
