package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class DataUtilitiesCalculateColumnTotal3Args {

	/**
	 * Test 46
	 * Uses mocking to input a 2D array containing values that stay in appropriate range
	 * create valid rows to check as well
	 * 
	 */
	@Test(timeout = 1000) // timer
	public void testCalculateColumnTotalForFourValues46(){
		//need a mock for Values2D tables
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class); // values is valriable to use in mock
		
		mockingContext.checking(new Expectations() {{ // create a mock to use for Values2D
		  	one(values).getRowCount(); 
		  		will(returnValue(4)); // setting how many rows 
		  		
            one(values).getValue(1, 2);
            	will(returnValue(  32.0  ));
            one(values).getValue(2, 2);
            	will(returnValue(  9.0   )); // sets up mocking example to be passed to fucntion for Values2d
            
		}});
		
	
		int [] validRows = {1,2}; //valid rows varibales to be passed in
		
		double expectedSum = 41.0;
		double actualSum = DataUtilities.calculateColumnTotal(values, 2, validRows); //call function using mock
		mockingContext.assertIsSatisfied();
	    assertEquals("Checking that fucntion returns correct sum", expectedSum, actualSum, .000000001d);
	}
	
	/**
	 * Test 47
	 * Boundary case using the max doubles added together to cause
	 *  overflow checking illegal arguments
	 */
	@Test(timeout = 1000) // timer
	public void testCalculateColumnTotalForThreeValuesAboveMaxValue47(){
		//need a mock for Values2D tables
		Mockery mockingContext = new Mockery(); // new mock object without context
		final Values2D values = mockingContext.mock(Values2D.class); // mocking Values2D object for context
		
		mockingContext.checking(new Expectations() {{ // setting up mock 
		  	one(values).getRowCount(); 
            will(returnValue(3));  // setting how many rows 
           
            one(values).getValue(0, 0); // get value from table at point (0,0)
            will(returnValue(Double.MAX_VALUE)); // its return value
            one(values).getValue(2, 0);
            will(returnValue(Double.MAX_VALUE));
		}});
		
		
		int [] validRows = {0,2};
		
		double expectedSum = Double.POSITIVE_INFINITY;
		double actualSum = DataUtilities.calculateColumnTotal(values, 0, validRows); //call function using mock
		mockingContext.assertIsSatisfied();
	    assertEquals("Checking that the column total is an overflow", expectedSum, actualSum, .000000001d);
	}
	
	
	
	/**
	 * Test 48
	 * for max negative numbers in each section of a column giving an overflow error
	 * the opposite of test ??
	 */
	@Test(timeout = 1000) // timer
	public void testCalculateColumnTotalForThreeValuesBelowMinValue48(){
		//need a mock for Values2D tables
		Mockery mockingContext = new Mockery(); // new mock object without context
		final Values2D values = mockingContext.mock(Values2D.class); // mocking Values2D object for context
		
		mockingContext.checking(new Expectations() {{ // setting up mock
		  	one(values).getRowCount();
            will(returnValue(3)); // setting how many rows 
            
            one(values).getValue(1, 1);
            will(returnValue(-Double.MAX_VALUE));
            one(values).getValue(2, 1);
            will(returnValue(-Double.MAX_VALUE));
		}});
		
		int [] validRows = {1,2};
		
		double expectedSum = Double.NEGATIVE_INFINITY;
		double actualSum = DataUtilities.calculateColumnTotal(values, 1, validRows); // call function using mock
		mockingContext.assertIsSatisfied();
	    assertEquals("Checking that the column total is an overflow", expectedSum, actualSum, .000000001d);
	}

	
	
	/**
	 * Test 49
	 * Test to check special illegal argument 
	 * if Value2d argument is null and passed to calculateColumnTotal
	 */
	@Test(expected = IllegalArgumentException.class) // expecting an exception
	public void testCalculateColumnWithNulldata49(){
		final Values2D values = null; // values is null
		int [] validRows = {1,2};
		DataUtilities.calculateColumnTotal(values, 0, validRows); // illegal args exception is thrown here
	}
	
	
	

}//end class
