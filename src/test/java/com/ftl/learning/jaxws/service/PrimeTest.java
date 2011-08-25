package com.ftl.learning.jaxws.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import com.ftl.learning.jaxws.manager.PrimeUtil;

public class PrimeTest {

	@Test
	@Ignore
	public void testIsPrimeRoot() {
		assertTrue(PrimeUtil.isPrimeRoot(7));
		assertFalse(PrimeUtil.isPrimeRoot(8));
		assertTrue(PrimeUtil.isPrimeRoot(997));
		assertTrue(PrimeUtil.isPrimeRoot(19997));
		assertTrue(PrimeUtil.isPrimeRoot(27449));
		assertTrue(PrimeUtil.isPrimeRoot(104729));
		assertTrue(PrimeUtil.isPrimeRoot(15485863));
		assertTrue(PrimeUtil.isPrimeRoot(179426549l));
		assertTrue(PrimeUtil.isPrimeRoot(6461334037l));
		assertTrue(PrimeUtil.isPrimeRoot(32416187567l));
		assertFalse(PrimeUtil.isPrimeRoot(32416187568l));
		assertTrue(PrimeUtil.isPrimeRoot(2305843009213693951l)); // 2^61-1

	}

	@Test
	public void testIsPrimeRecursively() {
		assertTrue(PrimeUtil.isPrimeRecursive(7));
		assertFalse(PrimeUtil.isPrimeRecursive(8));
		assertTrue(PrimeUtil.isPrimeRecursive(997));
		assertTrue(PrimeUtil.isPrimeRecursive(19997));
		assertTrue(PrimeUtil.isPrimeRecursive(27449));
		assertTrue(PrimeUtil.isPrimeRecursive(104729));
		assertTrue(PrimeUtil.isPrimeRecursive(15485863));
		assertTrue(PrimeUtil.isPrimeRecursive(179426549l));
		assertTrue(PrimeUtil.isPrimeRecursive(6461334037l));
		assertTrue(PrimeUtil.isPrimeRecursive(32416187567l));
		// assertTrue(PrimeUtil.isPrimeRecursive(2305843009213693951l)); //
		// 2^61-1
	}

}
