package com.abc;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilTest {
	
	@Test
	public void testToDollarsWithZero(){
		assertEquals("$0.00", Util.toDollars(0.0));
	}
	
	@Test
	public void testToDollarsWithNonZero(){
		assertEquals("$100.00", Util.toDollars(100.0));
	}
	
	@Test(expected = NullPointerException.class)
	public void testFormatWithNullString(){
		Util.format(1, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFormatWithNumberZero(){
		Util.format(0, "aaa");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFormatWithNumberLesserThanZero(){
		Util.format(-1, "aaa");
	}
	
	@Test
	public void testFormatWithNumberOne(){
		assertEquals("1 aaa", Util.format(1, "aaa"));
	}
	
	public void testFormatWithNumberGreaterThanOne(){
		assertEquals("2 aaas", Util.format(2, "aaa"));
	}

}
