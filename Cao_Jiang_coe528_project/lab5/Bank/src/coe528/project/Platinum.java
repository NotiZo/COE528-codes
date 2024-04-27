/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author notiz
 */
public class Platinum extends Level{
    public Platinum(){
        levelString="platinum";
        fee=0;
    }
    @Override
    public String getLevel(){
        return levelString;
    }
    @Override
    public int getFee(){
        return fee;
    }
    @Override
    public void setLevel(Customer customer){
        customer.level=new Platinum();
    }
    @Override
    public String toString() {
        return "Platinum";
    }
    
}
