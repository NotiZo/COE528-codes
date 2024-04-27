/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab3;

/**
 *
 * @author notiz
 */
public class Odometer implements Counter{
    
    private int numberofdigits;//no. of digits in odometer
    private AbstractCounter [] Array;//storing counters in array
    
    public Odometer(int numberofdigits){
        if (numberofdigits<1){//checks if no. of digits is valid
            throw new IllegalArgumentException("number of digits must be at least 1");
        } 
        
        this.numberofdigits=numberofdigits;//intializes the variable
        
        //intializing the array with the specific numberofdigits
        Array=new AbstractCounter[numberofdigits];
        
        //new digits counter array at first position of the array
        Array[0]=new DigitCounter();
        
        //initializing rest of array with linked digit counter
        for (int i=1;i<numberofdigits;i++){
            Array[i]=new LinkedDigitCounter(Array[i-1]);
        }
    }
    
    public void reset(){//resets to 0
        for (int i=0;i<numberofdigits;i++){
            Array[i].setCount(0);
        }
    }
    
    public String count(){
        String numbers = "";
        
        for (int i=0;i<numberofdigits;i++){//string representation of each counter
            numbers+=Array[i];
        }
        return numbers;
    }
    
    public void decrement(){//decrements by 1
        Array[numberofdigits-1].decrement();
    }
    
    public void increment(){//increments by 1
        Array[numberofdigits-1].increment();
    }
    
}
