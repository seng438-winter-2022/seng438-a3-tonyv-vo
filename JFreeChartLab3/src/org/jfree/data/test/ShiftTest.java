package org.jfree.data.test;
import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//JUnit test suite for the shift(Range base, double delta) method 
public class ShiftTest{
	static double shiftValue;
	
	//This method sets a value to shift the ranges by that all test cases will use
	//This is done once and before every test case
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		shiftValue = 20.0;
	}
	
	//Nothing is setup before every test case is done 
	@Before
	public void setUp() throws Exception {
	}

	
	//This test case sets the range to be on the positive side of 0
	//The range is shifted to the right by the shift value 
	@Test
	public void shiftWhenRangeInPositiveEnd_96() {	
		Range testRange1 = new Range(200, 400);
		Range result1 = Range.shift(testRange1, shiftValue);
		Range expected1 = new Range(testRange1.getLowerBound() + shiftValue, testRange1.getUpperBound() + shiftValue);
		
		assertEquals("Result should be (lowerbound+shiftvalue, upperbound+shiftValue)", expected1, result1);
		
	}
	
	
	//This test sets the range to be completely on the negative side of 0 
	//The range is shifted to the right by 0 
	@Test
	public void shiftWhenRangeInNegativeEnd_97() {	
		Range testRange2 = new Range(-200,-100);
		Range result2 = Range.shift(testRange2, shiftValue);
		Range expected2 = new Range(testRange2.getLowerBound() + shiftValue, testRange2.getUpperBound() + shiftValue);
		
		assertEquals("Result should be (lowerbound+shiftvalue, upperbound+shiftValue)", expected2, result2);
	}
	
	
	//This test case sets the lower bound of the range to be on 0 and the upper bound to be on the positive side of 0
	//The expected result is still the range shifted to the right by the shift value 
	@Test
	public void shiftWhenLowerBoundIsEqualZero_98() {	
		Range testRange3 = new Range(0, 100);
		Range result3 = Range.shift(testRange3, shiftValue);
		Range expected3 = new Range(testRange3.getLowerBound() + shiftValue, testRange3.getUpperBound() + shiftValue);
		
		assertEquals("Result should be (lowerbound+shiftvalue, upperbound+shiftValue)", expected3, result3);
	
	}
	
	
	//Upper bound is set to 0 and lower bound is set on the negative side of 0
	//The expected reuslt is still a shift to the right by the shift value 
	@Test
	public void shiftWhenUpperBoundIsEqualZero_99() {	
		Range testRange4 = new Range(-100, 0);
		Range result4 = Range.shift(testRange4, shiftValue);
		Range expected4 = new Range(testRange4.getLowerBound() + shiftValue, testRange4.getUpperBound() + shiftValue);
		
		assertEquals("Result should be (lowerbound+shiftvalue, upperbound+shiftValue)", expected4, result4);
	}
	
	
	//This test checks what happens when the lower bound is close to 0 but a lower unit number than the shift value
	//Expected result is a range with the lower bound of 0 and an upper bound shifted to the right by the shift value 
	@Test
	public void shiftWhenLowerBoundIsCloseToZeroAndShiftValue_100() {	
		Range testRange4 = new Range(-15, 100);
		Range result5 = Range.shift(testRange4, shiftValue);
		Range expected5 = new Range(0.0, testRange4.getUpperBound() + shiftValue);
		
		assertEquals("Result should be (0.0, upperbound+shiftValue)", expected5, result5);
	}
	
	
	//This test checks what happens when the upper bound is close to 0 but a lower unit number than the shift value
	//Expected result is a range with the upper bound of 0 and a lower bound shifted to the right by the shift value 
	@Test
	public void shiftWhenUpperBoundIsCloseToZeroAndShiftValue_101() {	
		Range testRange4 = new Range(-200, -10);
		Range result5 = Range.shift(testRange4, shiftValue);
		Range expected5 = new Range(testRange4.getLowerBound() + shiftValue, 0.0);
		
		assertEquals("Result should be (lowerbound+shiftvalue, 0.0)", expected5, result5);
	}
	
	@After
	public void tearDown() throws Exception {		
	}
	

}
