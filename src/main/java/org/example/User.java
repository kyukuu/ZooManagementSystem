package org.example;

public abstract class User { // abstract class, extended by admin and visitor
    //private variables and their getters and setters
    private String name;
    private int age;
    private long phoneNumber;
    private String email;
    private String password;

    private static User[] userList;

    public User(String name, int age, long phoneNumber,String email, String password) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static User[] getUserList() {
        return userList;
    }

    public static void setUserList(User[] userList) {
        User.userList = userList;
    }

    public abstract void addAnimal();

    public abstract void updateAnimalDetails();

    public abstract void removeAnimal();
}
