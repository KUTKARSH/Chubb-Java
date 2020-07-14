package com.example.animal;

import com.example.Playable;

public abstract class Animal implements Playable {

    protected String type;

    public String getType() {
        return type;
    }

    public String getName(){
        return name;
    }

    protected String name;
    protected Integer noOfLegs;

    public Animal(String name1,String name2,Integer noOfLegs,String type){
        this.type = type;
        this.name = name1;
        this.noOfLegs = noOfLegs;
    }

    public void eat(){

    }

    public void speak(){

    }

    @Override
    public void play(){
        System.out.println("PLAYING : I am " + name + ". A " + noOfLegs + " legged " + type + " Throw a ball, I can go-fetch!");
    }


}
