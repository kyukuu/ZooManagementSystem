package org.example;

import java.util.ArrayList;

public class AnimalReptile extends Animal{ //reptile class extended from animal
    private static ArrayList<AnimalReptile> animalReptileInventory= new ArrayList<>();

    public static ArrayList<AnimalReptile> getAnimalReptileInventory() {
        return animalReptileInventory;
    }

    public static void setAnimalReptileInventory(ArrayList<AnimalReptile> animalReptileInventory) {
        AnimalReptile.animalReptileInventory = animalReptileInventory;
    }

    //methods overriden in admin class as those functions can only by used by admin
    public AnimalReptile(String name, int type, String description, String voice) {
        super(name, type, description,voice);
    }

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
