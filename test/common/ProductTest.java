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
public class ProductTest {
    
    public ProductTest() {
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

    /**
     * Requires unitCost to be a value between 0 and 10_000.
     */
    @Test
    public void testSetUnitCostNotLessThanZero() {
        Product product = new Product();
        double[] testValues = {-1000, -500,-100, -10, -1};
        for (double v: testValues){
            try{
                product.setUnitCost(v);
                fail("Value Cannot be less than 0");
            }
            catch(IllegalArgumentException iae){
                //OK
            }
        }
    }
    
    @Test
    public void testSetProdNameNotNullOrEmpty(){
        Product product = new Product();
        String[] testValues = { null, "" };
        for (String s: testValues){
            try{
                product.setProdName(s);
                fail("Name can not be null or empty");
            }
            catch (IllegalArgumentException iae){
                //OK
            }
        }
    }
}
