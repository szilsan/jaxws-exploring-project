package com.ftl.learning.jaxws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ftl.learning.jaxws.manager.TestManager;
import com.ftl.learning.jaxws.service.dto.InvertDTO;
import com.ftl.learning.jaxws.service.dto.SumProdDTO;

@WebService(serviceName = "testService", name = "testService")
public class TestServiceImpl implements TestService {

	private static final Logger logger = LoggerFactory.getLogger(TestService.class);

	@Override
	@WebMethod
	public String invert(InvertDTO invertDTO) {
		if (invertDTO == null) {
			throw new IllegalArgumentException("Input object can not be null.");
		}

		return TestManager.invertString(invertDTO.getInputString());
	}

	@Override
	public double[] sumProd(SumProdDTO sumProdDTO) {
		if (sumProdDTO == null) {
			throw new IllegalArgumentException("Input object can not be null.");
		}

		return TestManager.sumProd(sumProdDTO.getX(), sumProdDTO.getY());
	}
}
