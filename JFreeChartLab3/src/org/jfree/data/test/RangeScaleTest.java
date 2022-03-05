package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.Test;

public class RangeScaleTest {


	
	/**
	 * Test 50
	 * tests scaling with inputs in bounds and the outputs also inbounds
	 * 
	 */
	
	@Test(timeout = 1000) // a timeout of 1000
	public void scaleNormalRange50(){ 
		Range ran= new Range(-10,10);
		Range actualRange = Range.scale(ran,2); // return the upper lower value which should be above max value 
		Range expectedRange = new Range(-20,20); // indicates overflow below maximum  negative double value
		
		assertTrue("Checking that scaling works on number in the bounds ", expectedRange.equals(actualRange)); // assert equals 
	}
	
	/**
	 * test 51
	 * tests for overflow when the max values are scaled
	 * 
	 */
	@Test(timeout = 1000) // a timeout of 1000
	public void overflowScaleTest51(){ 
		Range ran= new Range(-Double.MAX_VALUE,Double.MAX_VALUE);
		Range actualRange = Range.scale(ran,2); // return the upper lower value which should be above max value 
		Range expectedRange = new Range(Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY); // indicates overflow below maximum  negative double value
		
		assertTrue("Checking that input causes overflow ", expectedRange.equals(actualRange)); // assert equals 
	}
	
	
	/**
	 * Test 52
	 * tests for an illegal rguments exception when ther Range is created
	 */
	@Test(expected = IllegalArgumentException.class)  // expecting an exception to be thrown, fails if ot exception is thrown
	public void errorScaleTest52(){
		
		Range ran = new Range(10, 0);
		Range.scale(ran,2); // return the upper lower value which should be above max value 
		
	}
	
	
}//end class

