package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class SpecialDeals implements SpecialDealsMethods { //implements methods from interface
    private int noOfTickets;
    private double discountOnAllTickets;
    private static HashMap<Integer, Double> specialDealsInventory= new HashMap<Integer, Double>();
    Scanner input=new Scanner(System.in);

    public void setSpecialDeal(){ //setting deals
        System.out.print("Enter the number of tickets the deal needs to be levied on (at a time there can be only one discount on x number of tickets i.e. there can only by 1 spcial deal when you buy 2 tickets) : ");
        noOfTickets=input.nextInt();
        input.nextLine();
        System.out.print("Enter the the percentage discount to be levied on each ticket : ");
        discountOnAllTickets=input.nextDouble();
        input.nextLine();
        specialDealsInventory.put(noOfTickets,discountOnAllTickets);
        System.out.println("Special Deal added successfully");
    }

    public void removeSpecialDeal(){ //removing deals
        System.out.print("Enter the no. of tickets for which special deal needs to be revoked : ");
        noOfTickets=input.nextInt();
        input.nextLine();
        specialDealsInventory.remove(noOfTickets);
        System.out.println("Special Deal removed successfully");
    }

    @Override
    public void viewSpecialDeals() { //viewing deals
        for(int key: getSpecialDealsInventory().keySet()){
            System.out.println("No. of tickets you need to purchase : "+key);
            System.out.println("Discount on each ticket will be : ");
            System.out.println();
        }
    }

    public int getNoOfTickets() {
        return noOfTickets;
    }

    public void setNoOfTickets(int noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public double getDiscountOnAllTickets() {
        return discountOnAllTickets;
    }

    public void setDiscountOnAllTickets(double discountOnAllTickets) {
        this.discountOnAllTickets = discountOnAllTickets;
    }


    //static variables to store relevant information for the entire class
    public static HashMap<Integer, Double> getSpecialDealsInventory() {
        return specialDealsInventory;
    }

    public static void setSpecialDealsInventory(HashMap<Integer, Double> specialDealsInventory) {
        SpecialDeals.specialDealsInventory = specialDealsInventory;
    }

    public void applySpecialDeals(){
    }
}
