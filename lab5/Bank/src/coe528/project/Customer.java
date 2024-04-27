/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.FileNotFoundException;

/**
 *
 * @author notiz
 */
// Overview: Customer class with a username and password has the ability to deposit, withdraw and purchase. Each customer is assigned a level depending on their balance
//  This class is mutable
//
// The abstraction function is:
// a) Write the abstraction function here
//  AF(c)= Customer c
//  c.level=level of customer(silver, gold, or platinum) depending on their balance
//  c.username=Username of customer as a string
//  c.password=Password of a customer as a string
//  c.balance=the balance of a customers account
//
// The rep invariant is:
// b) Write the rep invariant here
//  RI(c) = True if
//  c.balance >= 0
//  c.username!=null
//  c.password!=null
//  otherwise it is true
//
//the rep
public class Customer {
    protected Level level;
    protected User user;
    protected double balance;
    protected boolean login;
    
    //requires: username and password are not null
    //modifies: user, balance, and login
    //effect: Makes a new user with the username and deposits the user's balance, sets login to false
    public Customer(String username, String password)throws FileNotFoundException{
        if (username==null||password==null) {
            throw new IllegalArgumentException("username and password cannot be null");
        }
        user=new User(username);
        balance=0;
        deposit(user.getBalance());
        login = false;
    }
    
    //getters
    public Level getLevel(){
        return level;
    }
    public User getUser(){
        return user;
    }
    public double getBalance(){
        return balance;
    }
    public boolean getLogin(){
        return login;
    }
    
    //setters
    public void setLevel(Level level){
        this.level=level;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
    
    //methods
    //modifies: login
    //effects: makes it false
    public void Logout(){
        login=false;
    }
    //modifies: login
    //effects: sets login in to true if the username and password matches
    public void Login(String username, String password){
        if(this.user.getUsername().equals(username)&&this.user.getPassword().equals(password)){
            login = true;
        }
    }
    //modifies: balance and level
    //effects: Adds the amount of deposited money to their balance and updates their level based off their new balance
    public void deposit(double amount) {//adds the deposited money to the current balance and resets their rank depending on new balance
        balance += amount;
        user.setBalance(balance);
        user.changeBalance();

        if (balance >= 20000) {
            level = new Platinum();
        } else if (balance >= 10000) {
            level = new Gold();
        } else {
            level = new Silver();
        }
    }
    //modifies: balance and level
    //effects: subtracts the user's balance by the withdrawed amount and updates their level based off their new balance
    public void withdraw(double amount){//subtracts the balance by the withdrrawed money and resets their rank depending on new balance
        balance -= amount;
        user.setBalance(balance);
        user.changeBalance();

        if (balance >= 20000) {
            level = new Platinum();
        } else if (balance >= 10000) {
            level = new Gold();
        } else {
            level = new Silver();
        }
    }
    //requires: purchase above 50
    //modifies: balance and level
    //effects: subtracts the user by the purchase along with the additional fee depending on their level, then it updates the user's level depending on their new balance
    public void purchase(double purchase){
        if (purchase >= 50) {
        balance -= (level.getFee() + purchase);
        user.setBalance(balance);
        user.changeBalance();
            if (balance >= 20000) {
                level = new Platinum();
            } else if (balance >= 10000) {
                level = new Gold();
            } else {
                level = new Silver();
            }
        } else {
        System.out.println("must be above $50");
        }
    }
    
    public boolean RepOk() {
        //effects: returns true if the balance is greater or equal to zero and username and password aint null, otherwise it returns false
        if(balance>=0&&user.getUsername()!=null&&user.getPassword()!=null){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String toString(){
        //Effects: returns username,balance,and level as a string
        return "Username: "+user.getUsername()+", Balance: $"+balance+", Level: "+level.getLevel();
    }
}
