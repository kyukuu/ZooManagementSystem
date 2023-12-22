package org.example;

import java.util.ArrayList;

public class AnimalMammal extends Animal{
    //static animal inventory
    private static ArrayList<AnimalMammal> animalMammalInventory= new ArrayList<>();
    public AnimalMammal(String name, int type, String description,String voice) {
        super(name, type, description,voice);
    }

    //overriden methods
    @Override
    public void addAnimal() {

    }

    @Override
    public void updateAnimalDetails() {

    }

    @Override
    public void removeAnimal() {

    }

    public static ArrayList<AnimalMammal> getAnimalMammalInventory() {
        return animalMammalInventory;
    }

    public static void setAnimalMammalInventory(ArrayList<AnimalMammal> animalMammalInventory) {
        AnimalMammal.animalMammalInventory = animalMammalInventory;
    }


    @Override
    public void viewAnimals() {

    }
}
