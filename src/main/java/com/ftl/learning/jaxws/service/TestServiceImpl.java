package com.ftl.learning.jaxws.service;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.shiro.SecurityUtils;
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

	@Resource
	private WebServiceContext wsContext;

	@Override
	@WebMethod
	// @RequiresAuthentication
	public String invert(InvertDTO invertDTO) {

		MessageContext msgContext = wsContext.getMessageContext();
		HttpServletRequest request = (HttpServletRequest) msgContext.get(MessageContext.SERVLET_REQUEST);
		HttpSession session = request.getSession();

		if (invertDTO == null) {
			throw new IllegalArgumentException("Input object can not be null.");
		}

		Subject currentUser = SecurityUtils.getSubject();

		logger.debug(LOGMarkers.SIMPLE_MARKER, "Logged user: " + currentUser);

		return TestManager.invertString(invertDTO.getInputString());
	}

	@Override
	// @RequiresAuthentication
	public SumProdResponseDTO sumProd(SumProdDTO sumProdDTO) {
		if (sumProdDTO == null) {
			throw new IllegalArgumentException("Input object can not be null.");
		}

		double[] response = TestManager.sumProd(sumProdDTO.getX(), sumProdDTO.getY());
		return new SumProdResponseDTO(response[0], response[1]);
	}
}
