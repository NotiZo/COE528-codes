/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author notiz
 */
public class User {
    //instance variable
    private String username;
    private String password;
    private String role;
    private double balance;
    
    public User(String username) throws FileNotFoundException{
        File file=new File(username+".txt");
        try (Scanner reader=new Scanner(file)){
        this.username=reader.nextLine();//reads first line of username
        this.password=reader.nextLine();//then password
        this.role=reader.nextLine();//then role
        this.balance=Double.parseDouble(reader.nextLine());//then their balance
        } catch (FileNotFoundException e) {
        throw new FileNotFoundException("file not found for " + username);
    }
  }
    //getters
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getRole(){
        return role;
    }
    public double getBalance(){
        return balance;
    }
    
    //setters
    public void setBalance(double balance){//balance is really the only one that gets changed
        this.balance=balance;
    }
    
    //change balance of the account (overwriting file)
    public void changeBalance(){
        try {
        File file = new File(username + ".txt");
        file.createNewFile(); // Ensure the file exists

        try (FileWriter Write = new FileWriter(username + ".txt")) {
            Write.write(username);
            Write.write("\n");
            Write.write(password);
            Write.write("\n");
            Write.write("customer");
            Write.write("\n");
            Write.write(Double.toString(balance));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
