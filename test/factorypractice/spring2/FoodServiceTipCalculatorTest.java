/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorypractice.spring2;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Mike
 */
public class FoodServiceTipCalculatorTest {
    
    public FoodServiceTipCalculatorTest() {
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

    //Requirements
    @Test
    public void testGetTipProperEquation() {
        FoodServiceTipCalculator foodServiceTipCalculator = new FoodServiceTipCalculator();
        foodServiceTipCalculator.setServiceQuality(ServiceQuality.GOOD);
        double[] testValues = { 12, 15, 3, 7, 1_000 };
        double[] expectedValues = { 2.4, 3, 0.6, 1.4, 200 };
        for (int i = 0; i < testValues.length; i++){
            foodServiceTipCalculator.setInputData(testValues[i]);
            assertEquals(expectedValues[i], foodServiceTipCalculator.getTip(), .001);
        } 
    }

    
    @Test
    public void testSetInputDataIllegalValues() {
        FoodServiceTipCalculator foodServiceTipCalculator = new FoodServiceTipCalculator();
        double[] testValues = { -12, -3.1, -5, 0 };
        for (double d: testValues){
            try {
            foodServiceTipCalculator.setInputData(testValues);
            } catch (IllegalArgumentException iae){
                //PASSED
            }
        }
    }
    
    @Test
    public void testSetInputDataLegalValues() {
        FoodServiceTipCalculator foodServiceTipCalculator = new FoodServiceTipCalculator();
        double[] testValues = { 12, 3.1, 5, 1_000 };
        for (double d: testValues){
            foodServiceTipCalculator.setInputData(d);
        }
    }
}
