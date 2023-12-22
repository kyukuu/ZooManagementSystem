package org.example;

import java.util.ArrayList;

public abstract class Animal implements AnimalMethods{
    //animal variables
    private String name;
    private int type;
    private String description;
    private String voice;

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    private static ArrayList<Animal>  animalInventory= new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ArrayList<Animal> getAnimalInventory() {
        return animalInventory;
    }

    public static void setAnimalInventory(ArrayList<Animal> animalInventory) {
        Animal.animalInventory = animalInventory;
    }

    public Animal(String name, int type, String description,String voice) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.voice=voice;
    }

    public abstract void addAnimal();

    public abstract void updateAnimalDetails();

    public abstract void removeAnimal();

    //overriding Animal tostring
    @Override
    public String toString() {
        System.out.println("Animal Name : "+this.getName());
        System.out.println("Description : "+this.getDescription());
        System.out.println("type : "+this.getType());

        return null;
    }
}
