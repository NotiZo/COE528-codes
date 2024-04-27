/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab4;

import java.util.ArrayList;

/**
 *
 * @author notiz
 * @param <G>
 */
public class QADT<G>{
// Overview: QADT implemented with an arraylist and follows the First-In-First-Out (FIFO) order.
//
// The abstraction function is:
//  AF(c)= queues that supports generic types of elements G such that for all c.queues.get(i) and 0<=i<c.queues.size())
//  G.first = c.queues.get(0)
//  G.last = c.queues.get(queuea.size()-1)
//
//
// The rep invariant is:
//  RI(c) = False if
//  c.queues.get(i)=null for 0<=i<c.queues.size()
//
//
//the rep
    
private final ArrayList<G> queues;

//Constructor
public QADT(){
        //Effects: creates a queues object
        queues=new ArrayList<>();
    }
    
public G dequeue(){
        //Modifies: queues
        //Effects: removes element from the front of the queues
        if (isEmpty()){
            throw new IllegalArgumentException("Cant dequeue element from an empty queue");
        }
        else{
            return queues.remove(0);
        }
    }

public void enqueue(G element){
        //Modifies: this
        //Effects: adds element to the end of the this
        queues.add(element);
    }

private boolean repOK(){
        //Effects: returns false if the this is null
        for (G queue:queues) { 
            if(queue==null) 
            return false; 
        }
       
        return true;
    }

    @Override
public String toString() {
        //Effects: returns this as a string
        StringBuilder sb = new StringBuilder();
        sb.append("");
        for (int i=0;i<queues.size();i++) {
            sb.append(queues.get(i));
            if (i<queues.size()-1) {
                sb.append(", ");
            }
        }
    return sb.toString();
    }

public boolean isEmpty(){
        //Effects: returns true if this is empty, otherwise false
        return queues.isEmpty();
    }
   


   public static void main(String[] args) {
// Test the queue implementation
QADT<Integer> queue = new QADT<>();
// Enqueue elements
queue.enqueue(10);
queue.enqueue(20);
queue.enqueue(30);
// Dequeue elements
int dequeuedElement1 = queue.dequeue(); // 10
int dequeuedElement2 = queue.dequeue(); // 20
// Check if the queue is empty
boolean isEmpty = queue.isEmpty(); // false
// Expected output
System.out.println("Dequeued element 1: " + dequeuedElement1);
System.out.println("Dequeued element 2: " + dequeuedElement2);
System.out.println("Is the queue empty? " + isEmpty);
}
    
}
