package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

public class RangeGetCentralValueTests {
	private Range rangeOne;
	private Range rangeTwo;
	
	/*
	 * This method sets rangeOne to a nominal and positive range.
	 */
	@Before
	public void setUpOne() throws Exception { 
		rangeOne = new Range(2.718, 6.28);
	}	
	
	/*
	 * This method sets rangeTwo to a range with a length of 0.
	 */
	@Before
	public void setUpTwo() throws Exception { 
		rangeTwo = new Range(0, 0);
	}
	
	/*
	 * Test case #69
	 * This test covers a nominal and positive range for the 
	 * lower and upper bound of the Range in the method getCentralValue(), 
	 * which should result in a central value of 1.78100
	 * Intended to fail - source code has defect
	 */
	@Test
	public void testGetCentralValue69() {
		assertEquals("The central value of rangeOne should be 1.78100",
				1.78100, rangeOne.getCentralValue(), .000000001d);
	}
	
	/*
	 * Test case #??
	 * This test covers a range with a length of 0 between the 
	 * lower and upper bound of the Range in the method getCentralValue(), 
	 * which should result in a central value of 0.0
	 */
	@Test
	public void testGetCentralValue70() {
		assertEquals("The central value of rangeTwo should be 0",
		0.0, rangeTwo.getLength(), .000000001d);
	}
	
	/*
	 * This method resets rangeOne back to a null value.
	 */
	@After
	public void tearDownOne() {
		rangeOne = null;
	}
	
	/*
	 * This method resets rangeTwo back to a null value.
	 */
	@After
	public void tearDownTwo() {
		rangeTwo = null;
	}
}
