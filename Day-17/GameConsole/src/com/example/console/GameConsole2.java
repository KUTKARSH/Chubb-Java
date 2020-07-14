package com.example.console;

import com.example.animal.Animal;
import com.example.animal.Cat;
import com.example.animal.Dog;
import com.example.wild.Lion;
import com.example.wild.Tiger;
import com.example.wild.WildAnimal;

import java.util.ArrayList;
import java.util.List;

public class GameConsole2 {
    private static List<Animal> animalList = new ArrayList<>();

    public static void tameAll() {
        animalList.forEach( (animal) -> {
            if(animal instanceof WildAnimal) {
                WildAnimal wildAnimal = (WildAnimal) animal;
                wildAnimal.tame();
            } else {
                System.out.println(animal.getType() + " is NOT a Wild Animal");
            }
        });
    }

    public static void main(String[] args) {

        Dog dog = new Dog("Scooby", "Ganesh");
        Cat cat = new Cat("Bella", "Babu");
        WildAnimal lion = new Lion("Leo", "Potter");
        WildAnimal tiger = new Tiger("Felix", "Harry");

        animalList.add(dog);
        animalList.add(cat);
        animalList.add(lion);
        animalList.add(tiger);

        tameAll();

    }

}
