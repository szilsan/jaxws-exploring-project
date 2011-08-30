package com.ftl.learning.jaxws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ftl.learning.jaxws.filter.LOGMarkers;
import com.ftl.learning.jaxws.manager.TestManager;
import com.ftl.learning.jaxws.service.dto.InvertDTO;
import com.ftl.learning.jaxws.service.dto.SumProdDTO;
import com.ftl.learning.jaxws.service.dto.SumProdResponseDTO;

@WebService(serviceName = "testService", name = "testService")
public class TestServiceImpl implements TestService {

	private static final Logger logger = LoggerFactory.getLogger(TestService.class);

	@Override
	@WebMethod
	@RequiresAuthentication
	public String invert(InvertDTO invertDTO) {
		if (invertDTO == null) {
			throw new IllegalArgumentException("Input object can not be null.");
		}

		Subject currentUser = SecurityUtils.getSubject();

		logger.debug(LOGMarkers.SIMPLE_MARKER, "Logged user: " + currentUser);

		return TestManager.invertString(invertDTO.getInputString());
	}

	@Override
	@RequiresAuthentication
	public SumProdResponseDTO sumProd(SumProdDTO sumProdDTO) {
		if (sumProdDTO == null) {
			throw new IllegalArgumentException("Input object can not be null.");
		}

		double[] response = TestManager.sumProd(sumProdDTO.getX(), sumProdDTO.getY());
		return new SumProdResponseDTO(response[0], response[1]);
	}
}
