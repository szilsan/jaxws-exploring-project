package com.ftl.learning.jaxws.aop;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ftl.learning.jaxws.filter.LOGMarkers;
import com.ftl.learning.jaxws.manager.UserUtil;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;


aspect ValidationAspect {

	private final Logger logger = LoggerFactory.getLogger(ValidationAspect.class);
	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	/**
	 * For web services in this project
	 */
	pointcut webMethods(Object dto): ((execution(@WebMethod * com.ftl.learning..*.*(..)) || execution(public * (@WebService com.ftl.learning..*).*(..))) && args(dto)) && !execution(public * com.ftl.learning.jaxws.filter*.*(..));

	before(Object dto): webMethods(dto) {
		logger.debug(LOGMarkers.BUSINESS_MARKER,"Call ftl web service. Service name: " + AspectUtil.getWebServicename(thisJoinPoint.getTarget().getClass()) + " / Method name: " + thisJoinPoint.getSignature().getName());
		validation(dto);
	}
	
	
	/**
	 * Validate an object
	 * 
	 * @param object
	 */
	private void validation(Object object) {
		Validator validator = factory.getValidator();
		if (object == null) {
			logger.error(LOGMarkers.BUSINESS_MARKER,"Parameter can not be null.");
			throw new IllegalArgumentException("Parameter can not be null.");
		}
		
		Set<ConstraintViolation<Object>> result = validator.validate(object);
		if (result.size() > 0) {
			StringBuffer errorMessage = new StringBuffer();
			for (ConstraintViolation<Object> cv : result) {
				errorMessage.append(cv.getMessage() + "\n");
			}
			logger.error(LOGMarkers.BUSINESS_MARKER,"Error during input validation: " + errorMessage.toString());
			throw new RuntimeException("Error during input validation: " + errorMessage.toString());
		}
	}
}