package org.example;

import java.util.ArrayList;

public class AnimalAmphibian extends Animal{
    //static amphibian list
    private static ArrayList<AnimalAmphibian> animalAmphibianInventory= new ArrayList<>();
    public AnimalAmphibian(String name, int type, String description, String voice) {
        super(name, type, description,voice);
    }

    public static ArrayList<AnimalAmphibian> getAnimalAmphibianInventory() {
        return animalAmphibianInventory;
    }

    public static void setAnimalAmphibianInventory(ArrayList<AnimalAmphibian> animalAmphibianInventory) {
        AnimalAmphibian.animalAmphibianInventory = animalAmphibianInventory;
    }

    //overriden methods in admin
    @Override
    public void addAnimal() {

    }

    @Override
    public void updateAnimalDetails() {

    }

    @Override
    public void removeAnimal() {

    }

    @Override
    public void viewAnimals() {

    }
}
