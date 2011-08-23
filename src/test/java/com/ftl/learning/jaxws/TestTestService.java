package com.ftl.learning.jaxws;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestTestService {

	private static TestService testService;

	@BeforeClass
	public static void beforeClass() {
		testService = new TestServiceImpl();
		assertNotNull(testService);
	}

	@Test
	public void testInvert() {
		assertEquals("almafa", testService.invert("ALMAFA"));
		assertEquals("ALMAFA", testService.invert("almafa"));
		assertEquals("alMAfa", testService.invert("ALmaFA"));
		assertEquals("   ", testService.invert("   "));
		assertEquals("+-almafa", testService.invert("+-ALMAFA"));
	}

	@Test
	public void testSumProd() {
		double ret[] = testService.sumProd(2, 3);
		assertTrue(ret.length == 2);
		assertTrue(ret[0] == 5);
		assertTrue(ret[1] == 6);
	}

}
