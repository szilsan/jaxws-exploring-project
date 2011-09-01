package com.ftl.learning.jaxws.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ftl.learning.jaxws.manager.TestManager;

/**
 * Test TestManager
 * 
 * @see TestTestManager
 */
public class TestTestManager {

	@Test
	public void testInvert() {
		assertEquals("almafa", TestManager.invertString("ALMAFA"));
		assertEquals("ALMAFA", TestManager.invertString("almafa"));
		assertEquals("alMAfa", TestManager.invertString("ALmaFA"));
		assertEquals("   ", TestManager.invertString("   "));
		assertEquals("+-almafa", TestManager.invertString("+-ALMAFA"));
	}

	@Test
	public void testSumProd() {
		double ret[] = TestManager.sumProd(2, 3);
		assertTrue(ret.length == 2);
		assertTrue(ret[0] == 5);
		assertTrue(ret[1] == 6);
	}
}
