package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeToStringTests {

	private Range rangeOne;
	
	/*
	 * This method sets rangeOne to a nominal and positive range.
	 */
	@Before
	public void setUpOne() throws Exception { 
		rangeOne = new Range(2.718, 6.28);
	}	
	
	/*
	 * Test case #86
	 * This test covers turning a Range object into a readable String
	 */
	@Test
	public void testToString86() {
		String result = rangeOne.toString();
		String expected = "Range[2.718,6.28]";
		assertTrue("The resulting String should be Range[2.718,6.28]", expected.equals(result));
	}
	
	/*
	 * This method resets rangeOne back to a null value.
	 */
	@After
	public void tearDownOne() {
		rangeOne = null;
	}

}
