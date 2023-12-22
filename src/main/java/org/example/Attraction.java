package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class Attraction implements AttractionMethods{
    //all attraction related variables made private
    private int attractionUID;
    private String attractionName;
    private String attractionDescription;
    private Double price;
    private boolean openOrClose;
    private static int UIDCount=0;
    //static variable to store various inventories
    public static ArrayList<Attraction> attractionInventory =new ArrayList<Attraction>();
    private static ArrayList<Visitor> visitorsWithTicket= new ArrayList<>();

    public static ArrayList<Visitor> getVisitorsWithTicket() {
        return visitorsWithTicket;
    }

    public static void setVisitorsWithTicket(ArrayList<Visitor> visitorsWithTicket) {
        Attraction.visitorsWithTicket = visitorsWithTicket;
    }

    Scanner input = new Scanner(System.in);


    //constructor
    public Attraction(int attractionUID, String attractionName, String attractionDescription, Double price, boolean openOrClose) {
        this.attractionUID = attractionUID;
        this.attractionName = attractionName;
        this.attractionDescription = attractionDescription;
        this.price = price;
        this.openOrClose = openOrClose;
    }

    @Override
    public String toString() {
        System.out.println("UID : "+this.getAttractionUID());
        System.out.println("Attraction Name : "+this.getAttractionName());
        System.out.println("Attraction Description : "+this.getAttractionDescription());
        System.out.println("Price : "+this.getPrice());
        System.out.println("Open/close : "+ this.isOpenOrClose());
        return null;
    }

    public int getAttractionUID() {
        return attractionUID;
    }

    public void setAttractionUID(int attractionUID) {
        this.attractionUID = attractionUID;
    }
    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

    public String getAttractionDescription() {
        return attractionDescription;
    }

    public void setAttractionDescription(String attractionDescription) {
        this.attractionDescription = attractionDescription;
    }

    public static int getUIDCount() {
        return UIDCount;
    }

    public static void setUIDCount(int UIDCount) {
        Attraction.UIDCount = UIDCount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isOpenOrClose() {
        return openOrClose;
    }

    public void setOpenOrClose(boolean openOrClose) {
        this.openOrClose = openOrClose;
    }

    public static ArrayList<Attraction> getAttractionInventory() {
        return attractionInventory;
    }

    public static void setAttractionInventory(ArrayList<Attraction> attractionInventory) {
        Attraction.attractionInventory = attractionInventory;
    }

    @Override //overriden
    public void addAttraction() {
    }

    @Override //overridden
    public void viewAttractions() {
        Iterator<Attraction> iterator=attractionInventory.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Override
    public void modifyAttraction() {

    }

    @Override
    public void removeAttraction() {
        System.out.println("Enter Attraction UID : ");
        String toFindName=input.nextLine();

        attractionInventory.removeIf(attraction -> Objects.equals(attraction.getAttractionUID(), toFindName));
    }
}
