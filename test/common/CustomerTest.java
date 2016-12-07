/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mike
 */
public class CustomerTest {
    
    public CustomerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    
    /**
     * Requires that setCustomerID be a number no less than 0 and
     * no greater than 1_000_000
     */
//    @Test(expected = IllegalArgumentException.class)
//    public void testSetCustomerIDNoLessThanZero(){
//        Customer customer = new Customer();
//        int testValue = -1;
//        customer.setCustomerId(testValue);
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void testSetCustomerIDNotLargerThanMillion(){
//        Customer customer = new Customer();
//        int testValue = 1_000_001;
//        customer.setCustomerId(testValue);
//    }
    
    @Test()
    public void testSetCustomerIDNoLessThanZero(){
        Customer customer = new Customer();
        int[] testValues = {-1000, -500,-100, -10, -1};
        for (int v: testValues){
            try{
                customer.setCustomerId(v);
                fail("Value Cannot be less than 1");
            }
            catch(IllegalArgumentException iae){
                //OK
            }
        }
        
    }
    
    @Test
    public void testSquare() {
        Customer customer = new Customer();
        int[] expected = {4,9,16};
        int[] testValues = {2,3,4};
        for (int i = 0; i < testValues.length; i++){
            assertEquals(expected[i], customer.getSquare(testValues[i]));
        }
    }
}
