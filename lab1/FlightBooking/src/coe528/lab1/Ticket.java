/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab1;

/**
 *
 * @author notiz
 */
public class Ticket {
    //instance variables
    private Passenger passenger;
    private Flight flight;
    private double price;
    private int ticketnumber;
    private static int totaltickets = 0;//whole class has access to this
    
    //constructor
    public Ticket(Passenger p, Flight f, double price){
        //initializing instance variables
        this.passenger = p;
        this.flight = f;
        this.price = price;
        this.ticketnumber = ++Ticket.totaltickets;
    }
   
    //getter & setters
    public Passenger getPassenger() {
        return passenger;
    }
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
    
    public Flight getFlight() {
        return flight;
    }
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getticketnumber() {
        return ticketnumber;
    }
    public void setticketnumber(int ticketnumber) {
        this.ticketnumber = ticketnumber;
    }
    
    //to string method
    @Override
    public String toString() {
        return String.format("%s, Flight %d, %s to %s, %s, original price: $%.2f, ticket price: $%.2f",this.passenger.getName() , this.flight.getFlightNumber(), this.flight.getOrigin(), this.flight.getDestination(), this.flight.getDepartureTime(), this.flight.getOriginalPrice(), this.price); 
    }
}
