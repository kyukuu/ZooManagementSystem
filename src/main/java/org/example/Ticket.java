package org.example;

public class Ticket { // auxillary class used to have an object of type ticket with relevant variables and methods
    private Attraction attraction;
    private double price;

    public Ticket(Attraction attraction1, double balance) {
        this.attraction=attraction1;
        this.price=balance;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
