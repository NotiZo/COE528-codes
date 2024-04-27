/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab4;

import java.util.ArrayList;

/**
 *
 * @author notiz
 */
public class StackOfDistinctStrings {
// Overview: StacksOfDistinctStrings are mutable, bounded
// collection of distinct strings that operate in
// LIFO (Last-In-First-Out) order.
//
// The abstraction function is:
// a) Write the abstraction function here
//  AF(c)= An arraylist items such that for all int i where 0<=i<(c.items.size()),
//  c.items.get(0)=bottom of stack
//  c.items.get(i)=distinct string
//  c.items.size()-1=top of stack  
//
// The rep invariant is:
// b) Write the rep invariant here
//  RI(c) = False for all int i and j if
//  c.items.get(i)=null for 0<=i<c.items.size
//  items.get(i).equals(items.get(j))=true for 0<=i<j<c.items.size
//
//the rep

    private ArrayList<String> items;
// constructor

    public StackOfDistinctStrings() {
// EFFECTS: Creates a new StackOfDistinctStrings object
        items = new ArrayList<String>();
    }

    public void push(String element) throws Exception {
// MODIFIES: this
// EFFECTS: Appends the element at the top of the stack
// if the element is not in the stack, otherwise
// does nothing.
        if (element == null) {
            throw new Exception();
        }
        if (false == items.contains(element)) {
            items.add(element);
        }
    }

    public String pop() throws Exception {
// MODIFIES: this
// EFFECTS: Removes an element from the top of the stack
        if (items.size() == 0) {
            throw new Exception();
        }
        return items.remove(items.size() - 1);
    }

    public boolean repOK() {
// EFFECTS: Returns true if the rep invariant holds for this
// object; otherwise returns false
// c) Write the code for the repOK() here
        if(items==null){//null item
            return false;
        }
        else{
            for(int i=0;i<items.size();i++){//duplicate item
                for(int j=i+1;j<items.size();j++){
                 if(items.get(i).equals(items.get(j))){
                    return false;
                   }
                }
            }
        }
        return true;
    }

    public String toString() {
// EFFECTS: Returns a string that contains the strings in the
// stack and the top element. Implements the
// abstraction function.
// d) Write the code for the toString() here
StringBuilder sb = new StringBuilder();
        for (int i=0;i<items.size();i++) {
            sb.append(items.get(i));
            if (i<items.size()-1) {
                sb.append(", ");
            }
        }
        sb.append(" and the top is ").append(items.get(items.size() - 1));
        return sb.toString();
    }
    
    //testing
    /*
    public static void main(String[] args) throws Exception { 
        StackOfDistinctStrings c = new StackOfDistinctStrings();
        c.push("blue");
        //wont add this one since its a duplicate
        c.push("blue");
        
        c.push("red");
        c.push("yellow");
        
        //pop
        System.out.println("Before pop: " + c);
        System.out.println("Popping: " +  c.pop());
        System.out.println(c);
        //should be true
        System.out.println(c.repOK());
        
        //sets 2nd element to be blue as well
        c.items.set(1, "blue"); 
        System.out.println(c);
        //repOk shoule output false cus duplicate
        System.out.println(c.repOK()); 
    }*/
}
