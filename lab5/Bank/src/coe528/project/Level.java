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
public abstract class Level {
    protected String levelString;
    protected int fee;
    
    public abstract String getLevel();
    public abstract int getFee();
    public abstract void setLevel(Customer customer);
    public abstract String toString();
}
