/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab1;

/**
 *
 * @author notiz
 */
public abstract class Passenger {//abstract class means it cant be initialized on its own, acts as common base for the member and nonmember class
    //instance variables
    String name;
    int age;
    
    //constructor
    public Passenger(String name, int age) {
        //initializing instance variables
        this.name = name;
        this.age = age;
    }
    
    //getters and setters
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getName() {
        return name;
    }    
    public void setName(String name) {
        this.name = name;
    }
    
    public abstract double applyDiscount(double p);//any class that extends the passenger must contain an applyDiscount method
}
