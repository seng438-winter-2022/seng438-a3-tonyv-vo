package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class RangeIntersectsTest {

	/**
	 * test 66
	 * ranges intersect
	 */
	@Test(timeout = 1000) // a timeout of 1000
	public void normalIntersectionTest66(){ 
		Range ran = new Range(-10,1);
		boolean intersect = ran.intersects(0,2); // return the upper lower value which should be above max value 
		
		assertTrue("ranges intersect ",intersect ); // assert equals 
	}
	
	/**
	 * test 67
	 * ranges do not intersect
	 */
	@Test(timeout = 1000) // a timeout of 1000
	public void noIntersectionTest67(){ 
		Range ran = new Range(-10,1);
		boolean intersect = ran.intersects(2,10); // return the upper lower value which should be above max value 
		
		assertFalse("ranges intersect ",intersect ); // assert equals 
	}
	
	/**
	 * test 68
	 * ranges intersect
	 */
	@Test(timeout = 1000) // a timeout of 1000
	public void closeButNoIntersectionTest68(){ 
		Range ran = new Range(-10,2);
		boolean intersect = ran.intersects(2,10); // return the upper lower value which should be above max value 
		
		assertFalse("ranges intersect ",intersect ); // assert equals 
	}
	
	/**
	 * Test case #93
	 * Ranges intersect, but intersects() receives a Range object
	 */
	@Test(timeout = 1000) // a timeout of 1000
	public void normalIntersectionTestWithRangeObject93(){ 
		Range ran = new Range(-10,1);
		boolean intersect = ran.intersects(ran);
		
		assertTrue("ranges intersect ", intersect);
	}

}
