package org.jfree.data.test;

import static org.junit.Assert.*;	
import org.jfree.data.DataUtilities;
import org.junit.*;

public class DataUtilitiesCloneTests
{
    	// test that array is cloned properly and returned array is equal to cloned array
	// test #91
	@Test(timeout = 1000)
	public void arrayIsClonedAndNewArrayReturnedProperly91()
	{
		double[][] array = {{ 1.5, 2.5}, { 3.13, 10.13, 5.66}, {9.0, 6.7, 2.1}};
		double[][] clonedArray = DataUtilities.clone(array);
		assertArrayEquals(array, clonedArray); 
	}
}
