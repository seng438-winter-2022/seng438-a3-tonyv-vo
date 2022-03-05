package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeExpandTests {

	private Range rangeOne;
	
	/*
	 * This method sets rangeOne to a nominal and positive range.
	 */
	@Before
	public void setUpOne() throws Exception { 
		rangeOne = new Range(2, 10);
	}	
	
	/*
	 * Test case #95
	 * This test covers expanding a range by a factor of 50% for the lower and upper bounds
	 */
	@Test
	public void testExpand95() {
		Range expected = new Range(-2, 14);
		Range result = Range.expand(rangeOne, 0.5, 0.5);
		assertTrue("The expanded range of rangeOne should be Range(-2, 14)", expected.equals(result));
	}
	
	/*
	 * This method resets rangeOne back to a null value.
	 */
	@After
	public void tearDownOne() {
		rangeOne = null;
	}

}
