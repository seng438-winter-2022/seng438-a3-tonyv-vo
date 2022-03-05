package org.jfree.data.test;

import java.lang.Math.*;
import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.Test;

public class RangeIsNaNRangeTest {

	/**
	 * test 62
	 * test with a null range retuns range with upper and lower are value NaN
	 */
	@Test(timeout = 1000) // a timeout of 1000
	public void useNaNAsUpperAndLowerTest62(){ 
		Range ran = new Range(Math.sqrt(-4), Math.sqrt(-4));
		boolean actual = ran.isNaNRange(); 
		
		assertTrue("true that lower and upper are NaN ", actual); // assert equals 
	}
	/**
	 * test 63
	 * range with one real num return false
	 */
	@Test(timeout = 1000) // a timeout of 1000
	public void useNaNAsUpperTest63(){ 
		Range ran = new Range(4, Math.sqrt(-4));
		boolean actual = ran.isNaNRange(); 
		
		assertFalse("Upper is NaN ", actual); // assert equals 
	}
	/**
	 * test 64
	 * range with one real num return false
	 * 
	 */
	@Test(timeout = 1000) // a timeout of 1000
	public void useNaNAsLowerTest64(){ 
		Range ran = new Range(Math.sqrt(-4),4);
		boolean actual = ran.isNaNRange(); 
		
		assertFalse("Lower is NaN ", actual); // assert equals 
	}
	/**
	 * test 65
	 * normal range return false
	 * 
	 */
	@Test(timeout = 1000) // a timeout of 1000
	public void UpperAndLowerAreNumsTest65(){ 
		Range ran = new Range(4,4);
		boolean actual = ran.isNaNRange(); 
		
		assertFalse("Upper and lower are real ", actual); // assert equals 
	}
	

}
