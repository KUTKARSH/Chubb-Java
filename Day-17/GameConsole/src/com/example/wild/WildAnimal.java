package com.example.wild;
import com.example.Playable;
import com.example.animal.Animal;

public abstract class WildAnimal extends Animal implements Playable {

    public WildAnimal(String name1,String name2,Integer noOfLegs,String type){
        super(name1,name2,noOfLegs,type);
    }

    public void tame(){
        System.out.println("TAMED : I am " + name + ". A " + noOfLegs + " legged " + type);
    }
}
