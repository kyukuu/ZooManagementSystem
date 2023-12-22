package org.example;

import java.util.ArrayList;

public class PremiumVisitor extends Visitor{ // child of visitor
    final private double BALANCE=0; //private final field for all premium visitors, balance is inconsequential as everything is free for them
    private static ArrayList<Visitor> premiumVisitors=new ArrayList<>(); //list of premium visitors

    public PremiumVisitor(String name, int age, long phoneNumber, String email, String password, double balance) {
        super(name, age, phoneNumber, email, password, balance);
    }

    public static ArrayList<Visitor> getPremiumVisitors() {
        return premiumVisitors;
    }

    public static void setPremiumVisitors(ArrayList<Visitor> premiumVisitors) {
        PremiumVisitor.premiumVisitors = premiumVisitors;
    }

    @Override
    public double getBalance() {
        return BALANCE;
    }

}
