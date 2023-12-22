package org.example;

import java.util.ArrayList;
import java.util.Scanner;

import static org.example.Animal.getAnimalInventory;
import static org.example.Attraction.attractionInventory;
import static org.example.Attraction.getVisitorsWithTicket;
import static org.example.Discount.getDiscountInventory;
import static org.example.Feedback.getFeedbackList;
import static org.example.PremiumVisitor.getPremiumVisitors;
import static org.example.SpecialDeals.getSpecialDealsInventory;


public class Visitor extends User implements AttractionMethodsVisitor, AnimalMethods, DiscountMethods,SpecialDealsMethods{
    Scanner input=new Scanner(System.in); // visitor inherits basic properties common with admin from user
//    other variables are defined here
    private double balance=0;
    private ArrayList<Ticket> purchasedTickets=new ArrayList<>();;
    //getter and setters for all methods
    public static ArrayList<Visitor> getVisitorArrayList() {
        return visitorArrayList;
    }

    public void setVisitorArrayList(ArrayList<Visitor> visitorArrayList) {
        Visitor.visitorArrayList = visitorArrayList;
    }

    private static ArrayList<Visitor> visitorArrayList=new ArrayList<>();

    public ArrayList<Ticket> getPurchasedTickets() {
        return purchasedTickets;
    }

    public void setPurchasedTickets(ArrayList<Ticket> purchasedTickets) {
        this.purchasedTickets = purchasedTickets;
    }

    public static double getRevenue() {
        return revenue;
    }

    public static void setRevenue(double revenue) {
        Visitor.revenue = revenue;
    }

    public static double revenue;
    //constructor
    public Visitor(String name, int age, long phoneNumber, String email, String password, double balance) {
        super(name, age, phoneNumber, email, password);
        this.balance = balance;
    }

    @Override // to string to print visitor information in view visitor
    public String toString() {
        return "Visitor Information:\n" +
                "Name: " + getName() + "\n" +
                "Age: " + getAge() + "\n" +
                "Phone Number: " + getPhoneNumber() + "\n" +
                "Email: " + getEmail() + "\n" +
                "Password: " + getPassword() + "\n" +
                "Balance: " + getBalance();
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override // to string to print info every attraction
    public void viewAttractions() {

        for (Attraction attraction : attractionInventory) {
            attraction.toString();
        }
    }

    @Override // to string to print info every animal
    public void viewAnimals() {
        for(Animal animal: getAnimalInventory()){
            animal.toString();
        }
    }

    public void buyTickets() {
        if (attractionInventory.isEmpty()) {
            System.out.println("No attractions available.");
            return;
        }

        System.out.println("Available attractions:");
        for (Attraction attraction : attractionInventory) {
            if (attraction.isOpenOrClose()) {
                System.out.println("1. UID: " + attraction.getAttractionUID() + "  Price: " + attraction.getPrice());
            }
        }

        System.out.println("Enter chosen UID: ");
        int choice = input.nextInt();
        input.nextLine();

        Attraction selectedAttraction = null;
        for (Attraction attraction : attractionInventory) {
            if (attraction.getAttractionUID() == choice) {
                selectedAttraction = attraction;
                break;
            }
        }

        if (selectedAttraction == null) {
            System.out.println("Invalid attraction UID. No ticket purchased.");
            return;
        }

        System.out.println("Enter discount code (if any) else write 'nil': ");
        String code = input.nextLine();
        Double afterDiscount = selectedAttraction.getPrice();

        if (!code.equals("nil") && getDiscountInventory().containsKey(code)) {
            Double discountPercentage = getDiscountInventory().get(code);
            afterDiscount = selectedAttraction.getPrice() * (1.0 - discountPercentage / 100.0);
        }

        if (getPremiumVisitors().contains(this) || this.balance >= afterDiscount) {
            this.balance -= afterDiscount;
            Ticket temp = new Ticket(selectedAttraction, this.balance);
            purchasedTickets.add(temp);
            getVisitorsWithTicket().add(this);
            revenue += afterDiscount;
            System.out.println("Ticket Purchased.");
        } else {
            System.out.println("Not enough balance to buy a ticket.");
        }
    }


    public void leaveFeedback(){ //take feedback
        System.out.println("Enter Email");
        String username=input.nextLine();
        System.out.println("Enter Feedback : ");
        String toSetFeedback=input.nextLine();
        getFeedbackList().put(username,toSetFeedback);
    }

    @Override //admin only function in interface, hence left unimplemented here
    public void addAnimal() {

    }

    @Override
    public void updateAnimalDetails() {

    }

    @Override
    public void removeAnimal() {

    }

    public void buyMembership(){ // basic and premium given enough balance
        System.out.println("1. Basic Membership : Rs. 20");
        System.out.println("2. Premium Membership : Rs. 50");
        int inp=input.nextInt();
        input.nextLine();
        if(inp==1){
            if(this.balance>20) {
                this.balance=this.balance-20;
                System.out.println("Basic Membership activated");
                setRevenue(getRevenue()+20);
            }
            else{
                System.out.println("Insufficient Balance");
            }
        }
        else if(inp==2){
            if(this.balance>50){
                this.balance=this.balance-50;
                getPremiumVisitors().add(this);
                setRevenue(getRevenue()+50);
                System.out.println("You are now a premium visitor");
            }
            else{
                System.out.println("Insufficient Balance");
            }
        }
    }

    @Override
    public void viewDiscount() { //view
        for (String key : getDiscountInventory().keySet()) {
            Double value = getDiscountInventory().get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }

    @Override //admin only function in interface, hence left unimplemented here - security
    public void addDiscount() {

    }

    @Override
    public void modifyDiscount() {

    }

    @Override
    public void removeDiscount() {

    }

    @Override
    public void setSpecialDeal() {

    }

    @Override
    public void removeSpecialDeal() {

    }

    @Override
    public void viewSpecialDeals() {
        for (int key : getSpecialDealsInventory().keySet()) {
            Double discount = getSpecialDealsInventory().get(key);
            System.out.println("No. of tickets you need to purchase: " + key);
            System.out.println("Discount on each ticket will be: " + discount);
            System.out.println();
        }
    }

    public void actionAnimal(){
        System.out.println("Select Animal : Enter Animal Name");
        String name=input.nextLine();
        for(Animal animal:getAnimalInventory()){
            if(name.equals(animal.getName())){
                System.out.println("1. Voice");
                System.out.println("2. Description");
                int action=input.nextInt();
                input.nextLine();
                if(action==1){System.out.println(animal.getDescription());}
                else if(action==2){System.out.println(animal.getVoice());}
            }
        }

    }
    public void applySpecialDeals(){ //applying deals on a unique number of tickets
        double discountPercentage=0;
        for(int key: getSpecialDealsInventory().keySet()){
            if(key==this.purchasedTickets.size()){
                System.out.println("Discount Applicable : "+getSpecialDealsInventory().get(key));
                discountPercentage=getSpecialDealsInventory().get(key);
                break;
            }
            for(Ticket ticket:purchasedTickets){
                ticket.setPrice(ticket.getPrice()-(discountPercentage*ticket.getPrice()/100));
            }
        }
    }

    public void visitAttraction(){
        System.out.println("Enter UID of Attraction you wish to visit");
        int entered=input.nextInt();
        input.nextLine();
        for(Ticket ticket: this.purchasedTickets){
            if(ticket.getAttraction().getAttractionUID()==entered){
                System.out.println("Attraction : "+ticket.getAttraction().toString());
                System.out.println("Attraction Visited !!!");
                this.purchasedTickets.remove(ticket);
                break;
            }
        }
    }

    public void visitAttraction(Visitor visitor){
        System.out.println("Enter UID of Attraction you wish to visit");
        int entered=input.nextInt();
        input.nextLine();
        for(Ticket ticket: this.purchasedTickets){
            if(ticket.getAttraction().getAttractionUID()==entered){
                System.out.println("Attraction : "+ticket.getAttraction().toString());
                System.out.println("Attraction Visited !!!");
                this.purchasedTickets.remove(ticket);
                break;
            }
        }
    }

}
