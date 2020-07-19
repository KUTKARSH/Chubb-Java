package com.example.PatchDemo.demo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String phoneNumber;

    public Integer getId() {
        return id;
    }

//    public User(Integer id, String name, String phoneNumber) {
//        this.id = id;
//        this.name = name;
//        this.phoneNumber = phoneNumber;
//    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}