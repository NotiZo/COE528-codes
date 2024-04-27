/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab3;

/**
 *
 * @author notiz
 */
public class LinkedDigitCounter extends AbstractCounter {
    //instance variable for left neighbour
    private Counter left;
    
    public LinkedDigitCounter(Counter left){
        this.left=left;
    }
 
    @Override
    public void increment() {//If the current value is 9, reset to 0 and increment the left neighbor
        if (value==9){
            value=0;
            left.increment();
        }
        else{
            value++;
        }
    }
    
    @Override
    public void decrement() {//If the current value is 0, set to 9 and decrement the left neighbor
        if (value==0){
            value=9;
            left.decrement();
        }
        else{
            value--;
        }
    }
    @Override
    public void reset(){
        setCount(0);
    }
    
}
