/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab3;

/**
 *
 * @author notiz
 */
public class DigitCounter extends AbstractCounter{

    @Override
    public void increment(){
        if (value==9){
            value=0;
        }
        else{
            value++;
        }
    }

    @Override
    public void decrement(){
        if (value==0){
            value=9;
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
