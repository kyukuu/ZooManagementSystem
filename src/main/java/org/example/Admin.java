package org.example;

import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

import static org.example.Animal.getAnimalInventory;
import static org.example.AnimalAmphibian.getAnimalAmphibianInventory;
import static org.example.AnimalMammal.getAnimalMammalInventory;
import static org.example.AnimalReptile.getAnimalReptileInventory;
import static org.example.Attraction.*;
import static org.example.Discount.discountInventory;
import static org.example.Discount.getDiscountInventory;
import static org.example.Feedback.getFeedbackList;
import static org.example.SpecialDeals.getSpecialDealsInventory;
import static org.example.Visitor.getVisitorArrayList;

public class Admin extends User implements AnimalMethods, AttractionMethods, DiscountMethods, FeedbackMethods, SpecialDealsMethods {
    Scanner input=new Scanner(System.in);

    //constructor
    public Admin(String name, int age, long phoneNumber, String email, String password) {
        super(name, age, phoneNumber,email, password);
    }

    @Override
    public void addAttraction() { // adding attraction after taking in relevant details
        System.out.println("Enter Attraction Name : ");
        String name=(input.nextLine());
        System.out.println("Enter Attraction Description : ");
        String description=(input.nextLine());
        System.out.println("Set Price for the ticket of the attraction : ");
        Double setPrice=input.nextDouble();
        System.out.println("Is the ride currently open? (true/false): ");
        boolean setOpen=input.nextBoolean();
        input.nextLine();
        Attraction newAttraction= new Attraction(getUIDCount(),name,description,setPrice,setOpen);
        int newUIDCount=Attraction.getUIDCount()+1;
        setUIDCount(newUIDCount);
        attractionInventory.add(newAttraction);
        System.out.println("Attraction Added Successfully");
    }

    @Override
    public void viewAttractions() { //view
        Iterator<Attraction> iterator=attractionInventory.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }

    @Override
    public void modifyAttraction() {//modify
        System.out.println("Enter Attraction UID: ");
        int getUIDval=input.nextInt();
        input.nextLine();

        for(Attraction attraction:attractionInventory){
            if(getUIDval==attraction.getAttractionUID())
            {
                attractionInventory.remove(attraction);
                break;
            }
        }
        System.out.println("Enter modified Attraction name : ");
        String tosetName=input.nextLine();
        System.out.println("Enter modified Attraction description : ");
        String tosetDescription=input.nextLine();
        System.out.println("Set Price for the ticket of the modified Attraction : ");
        Double setPrice=input.nextDouble();
        System.out.println("Is the ride currently open? : ");
        boolean setOpen=input.nextBoolean();
        Attraction newAttraction= new Attraction(getUIDval,tosetName,tosetDescription,setPrice,setOpen);
        attractionInventory.add(newAttraction);
        System.out.println("Attraction Modified Successfully");
    }

    @Override
    public void removeAttraction() { //remove
        System.out.println("Enter Attraction UID to be removed : ");
        int toFindName=input.nextInt();
        input.nextLine();

        attractionInventory.removeIf(attraction -> Objects.equals(attraction.getAttractionUID(), toFindName));
    }

    @Override
    public void addAnimal() { //add animal, for 3 types of animals as mentioned in the assignment
        System.out.println("Choose type of Animal : ");
        System.out.println("1. Mammal");
        System.out.println("2. Amphibian");
        System.out.println("3. Reptile");

        int tosetAnimalType=input.nextInt();
        input.nextLine();

//        System.out.println("Name of Animal : ");
//        String toSetName=input.nextLine();
//        System.out.println("Description of Animal : ");
//        String toSetDescription=input.nextLine();

        if(tosetAnimalType==1){
            System.out.println("Name of Animal : ");
            String toSetName=input.nextLine();
            System.out.println("Description of Animal : ");
            String toSetDescription=input.nextLine();
            System.out.println("Enter Animal Voice");
            String voice=input.nextLine();
            AnimalMammal tempAnimal= new AnimalMammal(toSetName,tosetAnimalType,toSetDescription,voice);
            getAnimalMammalInventory().add(tempAnimal);
            getAnimalInventory().add(tempAnimal);
        }
        if(tosetAnimalType==2){
            System.out.println("Name of Animal : ");
            String toSetName=input.nextLine();
            System.out.println("Description of Animal : ");
            String toSetDescription=input.nextLine();
            System.out.println("Enter Animal Voice");
            String voice=input.nextLine();
            AnimalAmphibian tempAnimal= new AnimalAmphibian(toSetName,tosetAnimalType,toSetDescription,voice);
            getAnimalAmphibianInventory().add(tempAnimal);
            getAnimalInventory().add(tempAnimal);
        }
        if(tosetAnimalType==3){
            System.out.println("Name of Animal : ");
            String toSetName=input.nextLine();
            System.out.println("Description of Animal : ");
            String toSetDescription=input.nextLine();
            System.out.println("Enter Animal Voice");
            String voice=input.nextLine();
            AnimalReptile tempAnimal= new AnimalReptile(toSetName,tosetAnimalType,toSetDescription,voice);
            getAnimalReptileInventory().add(tempAnimal);
            getAnimalInventory().add(tempAnimal);
        }


    }

    @Override
    public void updateAnimalDetails() { //add animal details for all 3 types
        System.out.println("Choose type of Animal : ");
        System.out.println("1. Mammal");
        System.out.println("2. Amphibian");
        System.out.println("3. Reptile");

        int tosetAnimalType=input.nextInt();

        if(tosetAnimalType==1){
            System.out.println("Current Name of Animal : ");
            String toGetName=input.nextLine();
            for(AnimalMammal animalMammal:getAnimalMammalInventory()){
                if (Objects.equals(animalMammal.getName(), toGetName)){
                    getAnimalMammalInventory().remove(animalMammal);
                    getAnimalInventory().remove(animalMammal);
                    break;
                }
            }
            System.out.println("Updated Name of Animal : ");
            String toSetName=input.nextLine();
            System.out.println("Updated Description of Animal : ");
            String toSetDescription=input.nextLine();
            System.out.println("Enter Animal Voice");
            String voice=input.nextLine();
            AnimalMammal tempAnimal= new AnimalMammal(toSetName,tosetAnimalType,toSetDescription,voice);
            getAnimalMammalInventory().add(tempAnimal);
            getAnimalInventory().add(tempAnimal);
        }
        if(tosetAnimalType==2){

            System.out.println("Current Name of Animal : ");
            String toGetName=input.nextLine();
            for(AnimalAmphibian animalAmphibian:getAnimalAmphibianInventory()){
                if (Objects.equals(animalAmphibian.getName(), toGetName)){
                    getAnimalAmphibianInventory().remove(animalAmphibian);
                    getAnimalInventory().remove(animalAmphibian);
                    break;
                }
            }
            System.out.println("Updated Name of Animal : ");
            String toSetName=input.nextLine();
            System.out.println("Updated Description of Animal : ");
            String toSetDescription=input.nextLine();
            System.out.println("Enter Animal Voice");
            String voice=input.nextLine();
            Animal tempAnimal= new AnimalAmphibian(toSetName,tosetAnimalType,toSetDescription,voice);
            getAnimalAmphibianInventory().add((AnimalAmphibian) tempAnimal);
            getAnimalInventory().add(tempAnimal);
        }
        if(tosetAnimalType==3){
            System.out.println("Current Name of Animal : ");
            String toGetName=input.nextLine();
            for(AnimalReptile animalReptile:getAnimalReptileInventory()){
                if (Objects.equals(animalReptile.getName(), toGetName)){
                    getAnimalReptileInventory().remove(animalReptile);
                    getAnimalInventory().remove(animalReptile);
                    break;
                }
            }
            System.out.println("Updated Name of Animal : ");
            String toSetName=input.nextLine();
            System.out.println("Updated Description of Animal : ");
            String toSetDescription=input.nextLine();
            System.out.println("Enter Animal Voice");
            String voice=input.nextLine();

            AnimalReptile tempAnimal= new AnimalReptile(toSetName,tosetAnimalType,toSetDescription,voice);
            getAnimalReptileInventory().add(tempAnimal);
            getAnimalInventory().add(tempAnimal);
        }
    }

    @Override
    public void removeAnimal() { // remove all three type of elements
        System.out.println("Choose type of Animal : ");
        System.out.println("1. Mammal");
        System.out.println("2. Amphibian");
        System.out.println("3. Reptile");

        int tosetAnimalType=input.nextInt();
        input.nextLine();

        System.out.println("Name of Animal : ");
        String toSetName=input.nextLine();

        if(tosetAnimalType==1){
            for(Animal animal:getAnimalInventory()){
                if(Objects.equals(animal.getName(), toSetName)){
                    getAnimalMammalInventory().remove(animal);
                    getAnimalInventory().remove(animal);
                    break;
                }
            }

        }
        if(tosetAnimalType==2){
            for(Animal animal:getAnimalInventory()){
                if(Objects.equals(animal.getName(), toSetName)){
                    getAnimalAmphibianInventory().remove(animal);
                    getAnimalInventory().remove(animal);
                    break;
                }
            }

        }
        if(tosetAnimalType==3){

            for(Animal animal:getAnimalInventory()){
                if(Objects.equals(animal.getName(), toSetName)){
                    getAnimalReptileInventory().remove(animal);
                    getAnimalInventory().remove(animal);
                    break;
                }
            }
        }
    }


    @Override // not useful here
    public void viewDiscount() {

    }

    @Override
    public void addDiscount() { // add discount
        System.out.println("Enter discount Code");
        String discountNameTemp=input.nextLine();
        System.out.println("Enter discount Percentage e.g. 10% , then enter 10");
        Double discountValueTemp=input.nextDouble();
        input.nextLine();
        getDiscountInventory().put(discountNameTemp,discountValueTemp);
    }

    @Override
    public void modifyDiscount() { //apply discount
        System.out.println("Enter Discount name to be modified : ");
        String toPutDiscount=input.nextLine();
        System.out.println("Enter modified discount name : ");
        String toFindDiscount=input.nextLine();
        System.out.println("Enter modified discount value : ");
        Double toFindValue= input.nextDouble();
        input.nextLine();

        getDiscountInventory().remove(toPutDiscount);// error handling?
        getDiscountInventory().put(toFindDiscount,toFindValue);
    }

    @Override
    public void removeDiscount() { //remove discount
        System.out.println("Enter Discount name to be modified : ");
        String toFindDiscount=input.nextLine();
        System.out.println("Enter Discount name to be modified : ");
        Double toFindValue= input.nextDouble();
        input.nextLine();

        getDiscountInventory().remove(toFindDiscount);// error handling?
    }

    @Override
    public void viewFeedback() { //view feedback
        for(String key: getFeedbackList().keySet()){
            System.out.println("key "+key);
            System.out.println("");
        }
    }

    @Override
    public void giveFeedBack() { //give  feedback
        System.out.println("Enter Email");
        String key = input.nextLine();
        System.out.println("Enter Feedback");
        String value = input.nextLine();
        getFeedbackList().put(key,value);
    }

    @Override // not used for admin
    public void viewAnimals() {

    }

    @Override
    public void setSpecialDeal() { //set deals
        System.out.print("Enter the number of tickets the deal needs to be levied on (at a time there can be only one discount on x number of tickets i.e. there can only by 1 spcial deal when you buy 2 tickets) : ");
        int noOfTickets=input.nextInt();
        input.nextLine();
        System.out.print("Enter the the percentage discount to be levied on each ticket : ");
        double discountOnAllTickets=input.nextDouble();
        input.nextLine();
        getSpecialDealsInventory().put(noOfTickets,discountOnAllTickets);
        System.out.println("Special Deal added successfully");
    }

    @Override
    public void removeSpecialDeal() { //remove deals
        System.out.print("Enter the no. of tickets for which special deal needs to be revoked : ");
        int noOfTickets=input.nextInt();
        input.nextLine();
        getSpecialDealsInventory().remove(noOfTickets);
        System.out.println("Special Deal removed successfully");
    }

    @Override
    public void viewSpecialDeals() { //view deals
        for(int key: getSpecialDealsInventory().keySet()){
            System.out.println("No. of tickets you need to purchase : "+key);
            System.out.println("Discount on each ticket will be : ");
            System.out.println();
        }
    }

    public void viewVisitorList(){ //view visitor list
        for(Visitor visitor: getVisitorArrayList()){
            System.out.println(visitor.toString());
            System.out.println();
        }
        System.out.println("Revenue : ");
        System.out.println(Visitor.getRevenue());
    }



}
