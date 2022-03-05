package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeHashCodeTests {

	private Range rangeOne;
	
	/*
	 * This method sets rangeOne to a nominal and positive range.
	 */
	@Before
	public void setUpOne() throws Exception { 
		rangeOne = new Range(2.718, 6.28);
	}	
	
	/*
	 * Test case #85
	 * This test generates a hash code
	 */
	@Test
	public void testHashCode85() {
		int result = rangeOne.hashCode();
		assertEquals("The hash code of rangeOne should be -1.911624739E9",
				-1.911624739E9, result, .000000001d);
	}
	
	/*
	 * This method resets rangeOne back to a null value.
	 */
	@After
	public void tearDownOne() {
		rangeOne = null;
	}

}
