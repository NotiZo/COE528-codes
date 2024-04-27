/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.*;

/**
 *
 * @author notiz
 */
public class Manager {
    protected User user;
    protected boolean login;
    
    public Manager(String username, String password){
        if (username.equals("admin")&&password.equals("admin")) {
            login = true;
        } else {
            login = false;
        }
    }
    
    //methods
    public void logout(){
        login = false;
    }
    public boolean getLogin(){
        return login;
    }
    protected boolean addCustomer(String username, String password){
        try {
        File file = new File(username + ".txt");
        if (!file.exists()) {
            file.createNewFile();
            try (FileWriter Write = new FileWriter(username + ".txt")) {
                Write.write(username);
                Write.write("\n");
                Write.write(password);
                Write.write("\n");
                Write.write("customer");
                Write.write("\n");
                Write.write("100.0");
            }
            return true; //successfully added
        } else {
            return false; //already exists
        }
    } catch (IOException e) {
        e.printStackTrace();
        return false; //error occurred
    }
   }
    
   protected boolean deleteCustomer(String username, String password){
     File file = new File(username + ".txt");
    if(file.exists()){
        file.delete();
        System.out.println("Customer "+username+" deleted successfully.");
        return true; //successfully deleted
    } else {
        System.out.println("Customer "+username+" not found.");
        return false; //not found
    }
  }
}