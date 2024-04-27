/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab1;

/**
 *
 * @author notiz
 */
public class NonMember extends Passenger {
    //no instance variables
    
    //constructor
    public NonMember(String name, int age){
        super(name, age);
    }
    
    @Override
    public double applyDiscount(double p){
        if(this.age > 65){//if the person is above 65 year old then apply a 10% discount
            return p*0.9;
        }else{
            return p;
        }
    } 
}
