package com.ftl.learning.jaxws.aop;
import java.lang.annotation.Annotation;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

aspect ServiceAspect {

	private final Logger logger = LoggerFactory.getLogger(ServiceAspect.class);

	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private static Validator validator = factory.getValidator();

	
	/**
	 * All public methods in this project
	 */
	pointcut publicMethods(): execution(public * com.ftl.learning..*.*(..));

	/**
	 * For web services in this project
	 */
	pointcut webMethods(Object dto): (execution(@WebMethod * com.ftl.learning..*.*(..)) ||execution(public * (@WebService com.ftl.learning..*).*(..))) && args(dto);

	before(): publicMethods() {
		//logger.debug("7Call ftl method: " + thisJoinPoint.getStaticPart().getSignature());
	}
	
	before(Object dto): webMethods(dto) {
		logger.debug("6Call ftl web service. Service name: " + getWebServicename(thisJoinPoint.getTarget().getClass()) + " / Method name: " + thisJoinPoint.getSignature().getName());
		validation(dto);
	}

	/**
	 * Validate an object
	 * 
	 * @param object
	 */
	private void validation(Object object) {
		if (object == null) {
			throw new IllegalArgumentException("Parameter can not be null.");
		}
		
		Set<ConstraintViolation<Object>> result = validator.validate(object);
		if (result.size() > 0) {
			StringBuffer errorMessage = new StringBuffer();
			for (ConstraintViolation<Object> cv : result) {
				errorMessage.append(cv.getMessage() + "\n");
			}
			throw new RuntimeException("Error during input validation: " + errorMessage.toString());
		}
	}
	
	private String getWebServicename(Class c) {
		Annotation[] annotations = c.getAnnotations();
		if (annotations.length == 0) {
			return "";
		}
		
		for (Annotation a: annotations) {
			if (a instanceof WebService) {
				return ((WebService) a).serviceName();
			}
		}
		return "";
	}
}