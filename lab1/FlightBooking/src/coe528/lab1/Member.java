/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab1;

/**
 *
 * @author notiz
 */
public class Member extends Passenger {
    //instance variables
    private int yearsOfMembership;
    
    //constructor
    public Member(String name, int age, int yearsOfMembership){
        super(name, age);//calls parent class variables from passenger
        this.yearsOfMembership = yearsOfMembership;
    }
    
    //setters and getters
    public int getYearsOfMembership() {
        return yearsOfMembership;
    }
    public void setYearsOfMembership(int yearsOfMembership) {
        this.yearsOfMembership = yearsOfMembership;
    }
    
    //applyDiscount method for p
    @Override
    public double applyDiscount(double p){
        if(this.yearsOfMembership > 5){
            return p*0.5;//50% discount if more than 5 years
        }else if(this.yearsOfMembership > 1){
            return p*0.9;//10% discount if less than 5 but more than 1
        }else{
            return p;//otherwise no discount
        }
    }
}
