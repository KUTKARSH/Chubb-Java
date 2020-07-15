package com.example.console;

import com.example.animal.Animal;
import com.example.animal.Dog;

import java.util.ArrayList;
import java.util.List;

public class GameConsole5 {
    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();

        System.out.println(String.format("Maximum Memory      : %6.2f mb", runtime.maxMemory() / (1024.0 * 1024)));
        System.out.println(String.format("Current used Memory : %6.2f mb", runtime.totalMemory() / (1024.0 * 1024)));
        System.out.println(String.format("Free Memory         : %6.2f mb", runtime.freeMemory() / (1024.0 * 1024)));

        try {
            List<Animal> animalList = new ArrayList<>();

            long i= 3;
            for (; ;i++ ) {
                Thread.sleep(5);
                animalList.add(new Dog("Scooby", "Ganesh"));
                if(i % 3 == 0)
                    animalList.remove(0);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
