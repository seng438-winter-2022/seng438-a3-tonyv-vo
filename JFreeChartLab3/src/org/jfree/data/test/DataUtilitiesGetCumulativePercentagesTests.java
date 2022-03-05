package org.jfree.data.test;

import static org.junit.Assert.*;										
import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jmock.*;
import org.junit.*;

public class DataUtilitiesGetCumulativePercentagesTests
{
	
	// tests one value from a key/value pair provides 100 cumulative percent 
	// test # 92
	@Test(timeout = 1000)
	public void get100PercentCumulativeWithOneItem92()
	{
		Mockery mockingContext = new Mockery(); // mock object without context
		final KeyedValues values = mockingContext.mock(KeyedValues.class); // mocking KeyedValues object for context
		mockingContext.checking(new Expectations() {{
			ignoring(values).getItemCount();
			will(returnValue(1)); // one key/value pair in ordered list
			ignoring(values).getKey(0);
			will(returnValue(1)); // return key of 1 at index 0 
			ignoring(values).getValue(0); 
			will(returnValue(5)); // return value of 5 at index 0 where key is 1
		}});
		mockingContext.assertIsSatisfied();
		KeyedValues actual = DataUtilities.getCumulativePercentages(values);
		double actualValue = (double)actual.getValue(0);
		assertEquals("cumulative percentage of value is 100", 1.0, actualValue, .000000001d); // 100 percent cumulative 
	}
}