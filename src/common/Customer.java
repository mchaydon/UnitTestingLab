/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author Mike
 */
public class Customer {
    private int customerId;

    public final void setCustomerId(int testValue) throws IllegalArgumentException{
        if (testValue < 0 || testValue > 1_000_000){
            throw new IllegalArgumentException("Illegal Value");
        } else {
            this.customerId = testValue;
        }
    }
    
    public int getSquare(int number){
        return number * number;
    }
    
}
