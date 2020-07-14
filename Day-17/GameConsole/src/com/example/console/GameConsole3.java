package com.example.console;

import com.example.AnimalGame;
import com.example.animal.Animal;
import com.example.animal.Cat;
import com.example.animal.Dog;
import com.example.wild.Lion;
import com.example.wild.Tiger;
import com.example.wild.WildAnimal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameConsole3 {
    private static List<Animal> animalList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        Dog dog = new Dog("Scooby", "Ganesh");
        Cat cat = new Cat("Bella", "Babu");
        WildAnimal lion = new Lion("Leo", "Potter");
        WildAnimal tiger = new Tiger("Felix", "Harry");

        animalList.add(dog);
        animalList.add(cat);
        animalList.add(lion);
        animalList.add(tiger);

        AnimalGame animalGame = new AnimalGame(animalList);

        animalGame.printAnimalListAlphabetically();

        // Add to Competition
        animalGame.addToSpeakingCompetition(Arrays.asList("Leo", "Bella"));
        animalGame.addToSpeakingCompetition("Felix");

        // Before Competition
        animalGame.printAnimalTypeCountsNotInCompetition();

        // Lastly added Animal must speak first
        animalGame.play();

        // After Competition
        animalGame.printAnimalTypeCountsNotInCompetition();

        // Find with time complexity O(1)
        animalGame.findAnimalByName("Scooby");
        animalGame.findAnimalByName("Cookie");

        // Throw Exception if Animal which is not in the game is added
        animalGame.addToSpeakingCompetition(Arrays.asList("Cookie"));
        
    }

}
