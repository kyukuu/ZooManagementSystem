package org.example;

import java.util.Objects;
import java.util.Scanner;

import static org.example.PremiumVisitor.getPremiumVisitors;
import static org.example.Visitor.getVisitorArrayList;

public class Zoo {
    public static void main(String[] args) {

        boolean userType=true;
        Scanner input= new Scanner(System.in);
//      declaration of admin
        Admin zooarian = new Admin("Koteshwar Rao", 35, 926 , "123","123");

        while(userType){

            System.out.println("Welcome to ZOOtopia");
            System.out.println("1. Enter as Admin");
            System.out.println("2. Enter as Visitor");
            System.out.println("3. View Special Needs");

            int user=input.nextInt();
            input.nextLine();

            if(user==1){
                System.out.print("Enter Username : ");
                String name=input.nextLine();
                System.out.print("Enter Password : ");
                String password=input.nextLine();

                if(!name.equals("123") || !password.equals("123")){
                    System.out.println("Invalid Credentials");
                    continue;
                }
                //check for user/password validity if wrong break else continue (use of object class)

                System.out.println("Admin Menu : "); //admin options implemented using admin class
                System.out.println("1. Manage Attractions");
                System.out.println("2. Manage Animals");
                System.out.println("3. Schedule Events");
                System.out.println("4. Set Discounts");
                System.out.println("5. Set Special Deals");
                System.out.println("6. View Visitor Stats");
                System.out.println("7. View Feedback");
                System.out.println("8. Exit");

                int option=input.nextInt();
                input.nextLine();

                if(option==1){
                    System.out.println("Manage Attractions : ");
                    System.out.println("1. Add Attraction");
                    System.out.println("2. View Attractions");
                    System.out.println("3. Modify Attraction");
                    System.out.println("4. Remove Attraction");
                    System.out.println("5. Exit");

                    int attractionInput=input.nextInt();
                    input.nextLine();

                    if(attractionInput==1){
                        zooarian.addAttraction();
                    }
                    if(attractionInput==2){
                        zooarian.viewAttractions();
                    }
                    if(attractionInput==3){
                        zooarian.modifyAttraction();
                    }
                    if(attractionInput==4){
                        zooarian.removeAttraction();
                    }
                    if(attractionInput==5){
                        continue;
                    }
                }

                if(option==2){
                    System.out.println("Manage Animals : ");
                    System.out.println("1. Add Animal");
                    System.out.println("2. Update Animal Details");
                    System.out.println("3. Remove Animal");
                    System.out.println("4. Exit");

                    int attractionInput=input.nextInt();
                    input.nextLine();

                    if(attractionInput==1){
                        zooarian.addAnimal();
                    }
                    if(attractionInput==2){
                        zooarian.updateAnimalDetails();
                    }
                    if(attractionInput==3){
                        zooarian.removeAnimal();
                    }
                    if(attractionInput==4){
                        continue;
                    }
                }

                if(option==3){
                    System.out.println("Schedule Events : ");
                    zooarian.addAttraction();
                }

                if(option==4){
                    System.out.println("Set Discounts : ");
                    System.out.println("1. Add Discount");
                    System.out.println("2. Modify Discount");
                    System.out.println("3. Remove Discount");
                    System.out.println("4. Exit");

                    int attractionInput=input.nextInt();
                    input.nextLine();

                    if(attractionInput==1){
                        zooarian.addDiscount();
                    }
                    if(attractionInput==2){
                        zooarian.modifyDiscount();
                    }
                    if(attractionInput==3){
                        zooarian.removeDiscount();
                    }
                    if(attractionInput==4){
                        continue;
                    }
                }

                if(option==5){
                    System.out.println("Set Special Deal : ");
                    zooarian.setSpecialDeal();
                }

                if(option==6){
                    System.out.println("View Visitor Stats : ");
                    zooarian.viewVisitorList();
                }

                if(option==7){
                    System.out.println("View Feedback : ");
                    zooarian.viewFeedback();
                }

                if(option==8){
                    System.out.println("Logged out as Admin");
                    continue;
                }

            }

            if(user==2){ // Login for user
                System.out.println("1. Register");
                System.out.println("2. Login");

                int userVisitor=input.nextInt();
                input.nextLine();

                if(userVisitor==1){
                    System.out.println("Enter Name : " );
                    String name=input.nextLine();
                    System.out.println("Enter Age : ");
                    int age=input.nextInt();
                    input.nextLine();
                    System.out.println("Enter PhoneNumber : ");
                    long phoneNumber=input.nextLong();
                    input.nextLine();
                    System.out.println("Enter Email  : ");
                    String email= input.nextLine();
                    System.out.println("Enter Password : ");
                    String password= input.nextLine();
                    System.out.println("Enter Balance : ");
                    double balance=input.nextDouble();
                    input.nextLine();
                    Visitor visitor=new Visitor(name, age,phoneNumber,email,password,balance);
                    getVisitorArrayList().add(visitor);
                }
                if(userVisitor==2){
                    System.out.print("Enter email : ");
                    String name=input.nextLine();
                    System.out.print("Enter Password : ");
                    String password=input.nextLine();
                    Visitor currentVisitor = null; // instantiating a user, can instantiate multiple users like this
                    for( Visitor visitor:getVisitorArrayList()){
                        if (Objects.equals(name, visitor.getEmail())) {
                        currentVisitor=visitor;
                        System.out.println("Visitor logged in successfully");
                        continue;}
                    }
                    if(currentVisitor==null){ // checking if the current visitor is null, program will exit otherwise
                        System.out.println("Visitor not found");
                        break;
                    }
                    //check for user/password validity if wrong break else the below mentioned code

                    System.out.println("Visitor Menu : ");
                    System.out.println("1. Explore the Zoo");
                    System.out.println("2. Buy Membership");
                    System.out.println("3. Buy Tickets");
                    System.out.println("4. View Discounts");
                    System.out.println("5. View Special Deals");
                    System.out.println("10. Apply Special Deals");
                    System.out.println("6. Visit Animals");
                    System.out.println("7. View Attractions");
                    System.out.println("8. Leave Feedback");
                    System.out.println("9. Exit");


                    int visiterMenu = input.nextInt();
                    input.nextLine();

                    if(visiterMenu==1){
                        System.out.println("Explore the Zoo : ");
                        System.out.println("1. View Attractions");
                        System.out.println("2. View Animals");
                        System.out.println("3. Exit");
                        int attractionInput=input.nextInt();
                        input.nextLine();

                        if(attractionInput==1){
                            currentVisitor.viewAttractions();
                        }
                        if(attractionInput==2){
                            currentVisitor.viewAnimals();
                        }
                        if(attractionInput==3) {
                            continue;
                        }
                    }

                    if(visiterMenu==2){
                        System.out.println("Buy Membership : ");
                        currentVisitor.buyMembership();
                    }

                    if(visiterMenu==3){
                        System.out.println("Buy Tickets : ");
                        currentVisitor.buyTickets();
                    }

                    if(visiterMenu==4){
                        System.out.println("View Discounts : ");
                        currentVisitor.viewDiscount();
                    }

                    if(visiterMenu==5){
                        System.out.println("View Special Deals : ");
                        currentVisitor.viewSpecialDeals();
                    }
                    if(visiterMenu==10){
                        System.out.println("Apply Special Deals : ");
                        currentVisitor.applySpecialDeals();
                    }

                    if(visiterMenu==6){
                        System.out.println("Visit Animals : ");
                        currentVisitor.viewAnimals();
                        currentVisitor.actionAnimal();
                    }

                    if(visiterMenu==7){
                        System.out.println("Visit Attractions : ");//overloaded polymorphism
                        currentVisitor.viewAttractions();
                        if(getPremiumVisitors().contains(currentVisitor)){
                            currentVisitor.visitAttraction(currentVisitor);
                        }
                        else{
                            currentVisitor.visitAttraction();
                        }
                    }

                    if(visiterMenu==8){
                        System.out.println("Visit Attractions : ");
                        currentVisitor.leaveFeedback();
                    }

                    if(visiterMenu==9){
                        System.out.println("Logged Out as Visitor: ");
                        continue;
                    }
                }
            }

            if(user==3){ //  can be accessed without being an admin or user
                System.out.println("Special Deals : ");
                zooarian.viewSpecialDeals();
            }

        }
    }
}
