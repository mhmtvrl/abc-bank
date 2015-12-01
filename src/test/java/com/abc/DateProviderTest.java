package com.abc;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateProviderTest {
	
	@Test
	public void testSingleton() {
		assertEquals(DateProvider.getInstance(), DateProvider.getInstance());
	}
	
}
