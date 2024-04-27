/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab3;

/**
 *
 * @author notiz
 */
public abstract class AbstractCounter implements Counter {
    int value;//value of the couonter

    public AbstractCounter(){
        this.value=0;//initialized to 0
    }

    @Override
    public void increment(){//increments counter value, wrapping around back to 0 when it reaches 9
        if (value==9) {
            value=0;
        }
        else{
            value++;
        }
    }

    @Override
    public void decrement(){//decrements counter value, wrapping around back to 9 when it reaches 0
        if (value==0){
            value=9;
        }
        else{
            value--;
        }
    }

    public void setCount(int value){//sets value of counter
        this.value=value;
    }

    @Override
    public String count(){//gets value of the counter as a string specific to counter
        return Integer.toString(value);
    }

    @Override
    public String toString(){//get string representation of the counter object
        return Integer.toString(value);
    }
}
