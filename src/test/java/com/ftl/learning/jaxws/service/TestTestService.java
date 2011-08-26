package com.ftl.learning.jaxws.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ftl.learning.jaxws.service.dto.InvertDTO;
import com.ftl.learning.jaxws.service.dto.SumProdDTO;
import com.ftl.learning.jaxws.service.dto.SumProdResponseDTO;

/**
 * Test TestService
 * 
 * It is different from TestManager. This test contains field validations too.
 * 
 * 
 */
public class TestTestService {

	private static TestService testService;

	@BeforeClass
	public static void beforeClass() {
		testService = new TestServiceImpl();
		assertNotNull(testService);
	}

	@Test
	public void testInvert() {
		InvertDTO invertDTO = new InvertDTO();
		invertDTO.setInputString("ALMAFA");
		assertEquals("almafa", testService.invert(invertDTO));

		invertDTO.setInputString("almafa");
		assertEquals("ALMAFA", testService.invert(invertDTO));

		invertDTO.setInputString("ALmaFA");
		assertEquals("alMAfa", testService.invert(invertDTO));

		invertDTO.setInputString("   ");
		assertEquals("   ", testService.invert(invertDTO));

		invertDTO.setInputString("+-ALMAFA");
		assertEquals("+-almafa", testService.invert(invertDTO));
	}

	@Test
	public void testSumProd() {
		SumProdDTO sumProdDTO = new SumProdDTO();
		sumProdDTO.setX(-2);
		sumProdDTO.setY(7);
		SumProdResponseDTO ret = testService.sumProd(sumProdDTO);
		assertTrue(ret.getSum() == 5);
		assertTrue(ret.getProd() == -14);
	}

	@AfterClass
	public static void afterClass() {
	}
}
