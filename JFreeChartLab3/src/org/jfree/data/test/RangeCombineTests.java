package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

public class RangeCombineTests {
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
	 * This method sets rangeTwo to a nominal and positive range.
	 */
	@Before
	public void setUpTwo() throws Exception { 
		rangeTwo = new Range(3.14, 9.81);
	}
	
	/*
	 * Test case #71
	 * This test covers combining two nominal and positive ranges from rangeOne and
	 * rangeTwo, which should result in a lower bound of 2.718
	 */
	@Test
	public void testCombineLower71() {
		Range result = Range.combine(rangeOne, rangeTwo);
		assertEquals("The minimum bound of the combined range should be 2.718",
				2.718, result.getLowerBound(), .000000001d);
	}
	
	/*
	 * Test case #72
	 * This test covers combining two nominal and positive ranges from rangeOne and
	 * rangeTwo, which should result in a upper bound of 9.81
	 */
	@Test
	public void testCombineUpper72() {
		Range result = Range.combine(rangeOne, rangeTwo);
		assertEquals("The upper bound of the combined range should be 9.81",
				9.81, result.getUpperBound(), .000000001d);
	}
	
	/*
	 * Test case #73
	 * This test covers combining a null range and a nominal and positive range from 
	 * rangeTwo, which should result in a lower bound of 3.14
	 */
	@Test
	public void testCombineNullOneLower73() {
		Range result = Range.combine(null, rangeTwo);
		assertEquals("The lower bound of the combined range should be 3.14",
				rangeTwo.getLowerBound(), result.getLowerBound(), .000000001d);
	}
	
	/*
	 * Test case #74
	 * This test covers combining a null range and a nominal and positive range from 
	 * rangeTwo, which should result in a upper bound of 9.81
	 */
	@Test
	public void testCombineNullOneUpper74() {
		Range result = Range.combine(null, rangeTwo);
		assertEquals("The upper bound of the combined range should be 9.81",
				rangeTwo.getUpperBound(), result.getUpperBound(), .000000001d);
	}
	
	/*
	 * Test case #75
	 * This test covers combining a nominal and positive range from rangeOne
	 * and a null range, which should result in a lower bound of 2.718
	 */
	@Test
	public void testCombineNullTwoLower75() {
		Range result = Range.combine(rangeOne, null);
		assertEquals("The lower bound of the combined range should be 3.14",
				rangeOne.getLowerBound(), result.getLowerBound(), .000000001d);
	}
	
	/*
	 * Test case #76
	 * This test covers combining a nominal and positive range from rangeOne
	 * and a null range, which should result in a upper bound of 6.28
	 */
	@Test
	public void testCombineNullTwoUpper76() {
		Range result = Range.combine(rangeOne, null);
		assertEquals("The upper bound of the combined range should be 9.81",
				rangeOne.getUpperBound(), result.getUpperBound(), .000000001d);
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
