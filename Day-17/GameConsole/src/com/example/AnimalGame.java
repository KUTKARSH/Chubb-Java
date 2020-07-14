package com.example;

import com.example.animal.Animal;

import java.util.*;

public class AnimalGame {

    TreeMap<String,String> animalMap; // stores animal name -> type mapping in the game
    Set<String> competition; // stores animals in competition
    ArrayList<String> nameStack;

    public AnimalGame(List<Animal> animalList){
        animalMap = new TreeMap<>();
        competition = new HashSet<>();
        for(Animal animal : animalList){
            animalMap.put(animal.getName(),animal.getType());
        }
//        animalList.forEach(animal -> animalMap.put(animal.getName(),animal.getType()));
        nameStack = new ArrayList<>();
    }

    public void addToSpeakingCompetition(List<String> competition) throws Exception{
        for(String name : competition){
            if(animalMap.containsKey(name) == false)
                throw new Exception("Only Animals included in the Game can be added to Competition!");
            nameStack.add(name);
            this.competition.add(name);
        }
    }

    public void addToSpeakingCompetition(String name){
        nameStack.add(name);
        this.competition.add(name);
    }

    public void printAnimalTypeCountsNotInCompetition(){
        Set<String> keys = animalMap.keySet();
        for(String key : keys){
            if(competition.contains(key) == false){
                System.out.println(animalMap.get(key) + " : " + 1);
            }
            else {
                System.out.println(animalMap.get(key) + " : " + 0);
            }
        }
    }

    public void play(){
        int s = nameStack.size();
        for(int i = s - 1 ; i >= 0 ; i--){
            if(animalMap.get(nameStack.get(i)).equals("CAT"))
                System.out.println(nameStack.get(i) + ":" + " I am meowing!");
            else if(animalMap.get(nameStack.get(i)).equals("LION"))
                System.out.println(nameStack.get(i) + ":" + " Here is the lion's roar!");
            else if(animalMap.get(nameStack.get(i)).equals("TIGER"))
                System.out.println(nameStack.get(i) + ":" + " Here is the tiger's growl!");
            else
                System.out.println(nameStack.get(i) + ":" + " Here is the dog's bark!");
        }
    }

    public void printAnimalListAlphabetically(){
        for(Map.Entry<String,String> e : animalMap.entrySet()){
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }

    public void findAnimalByName(String name){
        if(animalMap.containsKey(name) == false)
            System.out.println(name + " not found.");
        else
            System.out.println(name + " found");
    }

}
