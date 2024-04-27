/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab1;
import java.util.ArrayList;

/**
 *
 * @author notiz
 */
public class Manager {
    //arrays 
    ArrayList<Flight> Flights;
    ArrayList<Ticket> Tickets;
    
    public Manager(){
        this.Flights = new ArrayList<>();
        this.Tickets = new ArrayList<>();
    }
    
    //method for creating flights
    public void createFlights(){
        Flights.add(new Flight(1011,"Canada","China","03/02/2024 7:50 pm", 5 ,1000.21));
        Flights.add(new Flight(1012,"Canada","US","04/12/2024 8:50 pm", 10 ,759.12));
        Flights.add(new Flight(1013,"China","Canada","26/03/2024 9:50 pm", 2 ,699.24));
        Flights.add(new Flight(1014,"US","China","23/06/2024 1:50 pm", 7 ,1000));
        Flights.add(new Flight(1015,"China","US","01/12/2024 10:20 am", 1 ,750.01));
        Flights.add(new Flight(1016,"Canada","China","04/02/2024 10:20 am", 12 ,1023.01));
        
        //illegal arguments
        //Flights.add(new Flight(6,"Canada","Canada","03/02/2024 7:50 pm", 2 ,1000));//cannot be the same
        //Flights.add(new Flight(7,"Ontario","Quebec","03/02/2024 7:50 pm", 0 ,1000));//cant be 0 capacity
        //Flights.add(new Flight(-1,"Quebec","Ontario","03/02/2024 7:50 pm", 2 ,1000));//cannot be negative flight number
        //Flights.add(new Flight(9,"Canada","China","03/02/2024 7:50 pm", 2 ,-1000));//cannot be negative price
    }
    
    //method for displaying the array for available flights that arent fully booked
    public void displayAvailableFlights(String origin, String destination){
        System.out.println("-------------------------"); 
        System.out.println("List of available flights");
        System.out.println("-------------------------\n"); 
        boolean foundFlights=false;
        
        //loop that prints out the available flights as long as it isnt full
        for(Flight flight:Flights){//loops through the array using variable flight of type Flight
            //checks if the flights orgin and destination matches the provided one
            if (flight.getOrigin().equalsIgnoreCase(origin) && flight.getDestination().equalsIgnoreCase(destination)) {
                //Check if the flight is not full
                if (flight.getNumberOfSeatsLeft() > 0) {
                //prints out the available flights
                System.out.println(flight.toString());
                foundFlights = true;
                }
            }
        }//end of loop here
        
        //if there isnt any matching flights or all are full
        if (foundFlights==false){
            System.out.println("Sorry no flights are available for your orgin and destination.");
        }
        
    }
    
    //method for getting flights
    public Flight getFlight(int flightNumber){
        //loop that returns the desired flight if it matches the flight number
        for (Flight flight:Flights){
            if (flight.getFlightNumber()==flightNumber){
                return flight; //Return the Flight object when the flight number matches
            }
        }
        return null;//leaving this as null
    }
    
    public void bookSeat(int flightNumber, Passenger p){
        System.out.print("----------------------------------\n");
        System.out.print("Booking for desired flight number \n");
        System.out.print("----------------------------------\n");
        
        //getting the desired flight number to be booked
        Flight desiredFlight = getFlight(flightNumber);//calling the getFlight method

        if (desiredFlight != null){//if there is a flight number that matches the desired flight
        //Try to book a seat on the flight
        boolean booked = desiredFlight.bookASeat();

            if (booked){
            //Apply discount based on passenger type (Member or NonMember)
            double ticketPrice;

                if (p instanceof Member){//If passenger is a Member, apply discount using Member's applyDiscount method
                    Member member=(Member) p; //p is type passneger Cast to Member to access Member specific methods
                    ticketPrice=member.applyDiscount(desiredFlight.getOriginalPrice());
                }else{//defaults to nonmember, applying discount using NonMember's applyDiscount method
                    NonMember nonMember=(NonMember) p; //Cast to NonMember to access NonMember specific methods
                    ticketPrice=nonMember.applyDiscount(desiredFlight.getOriginalPrice());
                    }
                
                //Creates a new Ticket for the passenger and the booked flight
                Ticket newTicket=new Ticket(p, desiredFlight, ticketPrice);
                Tickets.add(newTicket);
                System.out.println("Seat booked successfully. Ticket details: " + newTicket.toString());
            }else{
                System.out.println("Sorry the flight is fully booked. Seat booking failed.");
                }
        }else{
            System.out.println("Flight with flight number "+flightNumber+" not found.");
            }
    }
    
    public static void main(String[] args ){
        Manager m = new Manager();
        
        //array of passengers
        Passenger[] passenger = {
            new Member("Bob1",20,6),
            new Member("Bob2",24,2),
            new Member("bob3",26,1),
            new Member("bob4",27,0),
            new NonMember("bob5",36), 
            new NonMember("bob6",66), 
            new NonMember("bob7",22)
        };
        
        //creating flights
        m.createFlights();
        
        //displaying flights for canada to china
        m.displayAvailableFlights("Canada","china");
        
        //displaying flights for china to canada
        m.displayAvailableFlights("china", "canada");
        
        //booking seats
        m.bookSeat(1013, passenger[0]); //will book successfully, discount of 50% will be applied
        System.out.println("\t50% discount applied");
        m.bookSeat(1013, passenger[1]); //will book successfully, discount of 10% will be applied
        System.out.println("\t10% discount applied");
        m.bookSeat(1013, passenger[2]); //will not book, since flight is full
        System.out.println("\tFlight is full");
        m.bookSeat(1015, passenger[3]); //will book successfully, no discount will be applied
        System.out.println("\tno discount applied");
        m.bookSeat(1016, passenger[4]); //will book successfully, no discount will be applied
        System.out.println("\tno discount applied");
        m.bookSeat(1016, passenger[5]); //will book successfully, discount of 10% will be applied
        System.out.println("\t10% discount applied");
        
        //displaying flights for china to canada
        //m.displayAvailableFlights("China","Canada");
    }
}
