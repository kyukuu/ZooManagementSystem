package org.example;
import java.util.*;

public class Discount implements DiscountMethods{ //implements interface
    private String category;
    private double discountPercentage;

    public void setCategory(String category) {
        this.category = category;
    }

    public static HashMap<String, Double> getDiscountInventory() {
        return discountInventory;
    }

    //static hashmap to store all discounts
    public static void setDiscountInventory(HashMap<String, Double> discountInventory) {
        Discount.discountInventory = discountInventory;
    }

    static HashMap <String , Double> discountInventory = new HashMap<>();
    Scanner input= new Scanner(System.in);
    public String getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = String.valueOf(category);
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public void viewDiscount() { // function overriden in visitor

    }

    @Override
    public void addDiscount() { //add discount
        System.out.println("Enter discount Code");
        String discountNameTemp=input.nextLine();
        System.out.println("Enter discount Percentage e.g. 10% , then enter 10");
        Double discountValueTemp=input.nextDouble();
        discountInventory.put(discountNameTemp,discountValueTemp);
    }

    @Override
    public void modifyDiscount() {//apply discount
        System.out.println("Enter Discount name to be modified : ");
        String toPutDiscount=input.nextLine();
        System.out.println("Enter modified discount name : ");
        String toFindDiscount=input.nextLine();
        System.out.println("Enter modified discount value : ");
        Double toFindValue= input.nextDouble();

        discountInventory.remove(toPutDiscount);// error handling?
        discountInventory.put(toFindDiscount,toFindValue);

    }

    @Override
    public void removeDiscount() {//remove discount
        System.out.println("Enter Discount name to be modified : ");
        String toFindDiscount=input.nextLine();
        System.out.println("Enter Discount name to be modified : ");
        Double toFindValue= input.nextDouble();

        discountInventory.remove(toFindDiscount);// error handling?
    }
}
