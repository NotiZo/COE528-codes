/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab1;

/**
 *
 * @author notiz
 */
public class Flight {
    //instance variables of type integers
    private int flightNumber;
    private int capacity;
    private int numberOfSeatsLeft;
    
    //instance variables of type String
    private String origin;
    private String destination;
    private String departureTime;
    
    //instance variable of type double
    double originalPrice;
    
    //constructor
    public Flight(int flightNumber, String origin, String destination, String departureTime, int capacity, double originalPrice) {
        //intiallizing instance variable
        this.flightNumber=flightNumber;
        this.capacity=capacity;
        this.originalPrice=originalPrice;
        this.origin=origin;
        this.destination=destination;
        this.departureTime=departureTime;
        this.numberOfSeatsLeft=capacity;
        
        //illegal arguments
        if(destination.equals(origin) == true) {
          throw new IllegalArgumentException("The orgin and destination can't be the same.");  
        }
        if(capacity <= 0) { 
            throw new IllegalArgumentException("capacity of plane can't be negative or zero.");
        }
        if(originalPrice < 0) {
            throw new IllegalArgumentException("original price of flight can't be negative.");
        }
        if(flightNumber<0){
            throw new IllegalArgumentException("Flight number can't be below 0");
        }
        if(numberOfSeatsLeft<0){
            throw new IllegalArgumentException("number of seats left can't be negative");
        }
        //end of illegal arguments
    }//end of constructor
    
    //bookASeat method
    public boolean bookASeat(){//if the number of seat is greater than 0 decrement and return true
        if(numberOfSeatsLeft > 0) {
            numberOfSeatsLeft--;
            return true;
        }//otherwise returns false
        else
            return false;
    }
    
    //getter method
    public int getFlightNumber() {
        return flightNumber;
    }
    //setter method
    public void setFlightNumber(int flightNumber) {
        this.flightNumber=flightNumber;
    }
    
    //getter method
    public int getCapacity() {
        return capacity;
    }
    //setter method
    public void setCapacity(int capacity) {
        this.capacity=capacity;
    }
    
    //getter method
    public int getNumberOfSeatsLeft() {
        return numberOfSeatsLeft;
    }
    //setter method
    public void setNumberOfSeatsLeft(int c) {
        numberOfSeatsLeft = c;
    }
    
    //getter method
    public String getOrigin() {
        return origin;
    }
    //setter method
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    //getter method
    public String getDestination() {
        return destination;
    }
    //setter method
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    //getter method
    public String getDepartureTime() {
        return departureTime;
    }
    //setter method
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    
    //getter method
    public double getOriginalPrice() {
        return originalPrice;
    }
    //setter method
    public void setOriginalPrice(double price1) {
        originalPrice = price1;
    }

    //to string method
    @Override
    public String toString() {
        return "Flight Number: " + getFlightNumber() + ", " + getOrigin() + " to " + getDestination() + ", " + getDepartureTime() + ", Original Price: $" + getOriginalPrice() + "\n";
    }
    
}
