package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class RangeShiftTest {

	/**
	 * Test 53
	 * 
	 * normal shift with a positive shift value
	 */
	@Test(timeout = 1000) // a timeout of 1000
	public void shiftNormalRangePositiveShift53(){ 
		Range ran = new Range(-10,10);
		Range actualRange = Range.shift(ran,2); // return the upper lower value which should be above max value 
		Range expectedRange = new Range(-8,12); // indicates overflow below maximum  negative double value
		
		assertTrue("check that shift works for normal range with positive shift ", expectedRange.equals(actualRange)); // assert equals 
	}
	
	/**
	 * Test 54
	 * normal shift with a negative shift value
	 * 
	 */
	@Test(timeout = 1000) // a timeout of 1000
	public void shiftNormalRangeNegativeShift54(){ 
		Range ran = new Range(-10,10);
		Range actualRange = Range.shift(ran,-2); // return the upper lower value which should be above max value 
		Range expectedRange = new Range(-12,8); // indicates overflow below maximum  negative double value
		
		assertTrue("check that shift works for normal range with negative shift ", expectedRange.equals(actualRange)); // assert equals 
	}
	
	/**
	 * Test 55
	 * TESTS OVERFLOW AND also at the boundary condition
	 * 
	 */
	@Test(timeout = 1000) // a timeout of 1000
	public void shiftToOverflowPositive55(){ 
		Range ran = new Range(0, Double.MAX_VALUE);
		Range actualRange = Range.shift(ran, Double.MAX_VALUE); // return the upper lower value which should be above max value 
		Range expectedRange = new Range(Double.MAX_VALUE, Double.POSITIVE_INFINITY); // indicates overflow below maximum  negative double value
		
		
		assertTrue("Checking that shift works for positive overflow ", expectedRange.equals(actualRange)); // assert equals 
	}

	/**
	 * Test 56
	 * 
	 * checking for negative overflow
	 */
	@Test(timeout = 1000) // a timeout of 1000
	public void shiftToOverflowNegative56(){ 
		Range ran = new Range( -Double.MAX_VALUE, 0);
		Range actualRange = Range.shift(ran, -Double.MAX_VALUE); // return the upper lower value which should be above max value 
		Range expectedRange = new Range(Double.NEGATIVE_INFINITY, -Double.MAX_VALUE); // indicates overflow below maximum  negative double value
		
		assertTrue("Checking that shift works for negative overflow ", expectedRange.equals(actualRange)); // assert equals 
	}
	
	/**
	 * Test 94
	 * 
	 * Check shift with allowZeroCrossing set to true
	 */
	@Test(timeout = 1000) // a timeout of 1000
	public void testAllowZeroCrossingTrue94(){ 
		Range ran = new Range(-5, 10);
		Range actualRange = Range.shift(ran, 7, true);
		Range expectedRange = new Range(2, 17);
		
		assertTrue("Checking that shift works for negative overflow ", expectedRange.equals(actualRange)); // assert equals 
	}
	
}


