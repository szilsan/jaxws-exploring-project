package com.ftl.learning.jaxws;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestTestService {

	private static TestService testService;

	@BeforeClass
	public static void before() {
		testService = new TestServiceImpl();
		Assert.assertNotNull(testService);
	}

	@Test
	public void testInvert() {
		Assert.assertEquals("almafa", testService.invert("ALMAFA"));
		Assert.assertEquals("ALMAFA", testService.invert("almafa"));
		Assert.assertEquals("alMAfa", testService.invert("ALmaFA"));
		Assert.assertEquals("   ", testService.invert("   "));
		Assert.assertEquals("+-almafa", testService.invert("+-ALMAFA"));
	}

	@Test
	public void testSumProd() {
		double ret[] = testService.sumProd(2, 3);
		Assert.assertTrue(ret.length == 2);
		Assert.assertTrue(ret[0] == 5);
		Assert.assertTrue(ret[1] == 6);
	}

}
