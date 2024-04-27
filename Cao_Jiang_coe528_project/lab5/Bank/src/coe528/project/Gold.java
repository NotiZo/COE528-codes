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
public class Gold extends Level{
    public Gold(){
        levelString="gold";
        fee=10;
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
        customer.level=new Gold();
    }
    @Override
    public String toString() {
        return "Gold";
    }
}
