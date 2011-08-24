package com.ftl.learning.jaxws.aop;
import java.lang.annotation.Annotation;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

aspect ServiceAspect {

	final Logger logger = LoggerFactory.getLogger(ServiceAspect.class);

	/**
	 * All public methods in this project
	 */
	pointcut publicMethods(): execution(* com.ftl.learning..*.*(..));

	/**
	 * For web services in this project
	 */
	pointcut webMethods(): execution(@WebMethod * com.ftl.learning..*.*(..)) ||execution(public * (@WebService com.ftl.learning..*).*(..));

	before(): publicMethods() {
		logger.debug("Call ftl method: " + thisJoinPoint.getStaticPart().getSignature());
	}

	before(): webMethods() {
		logger.debug("Call ftl web service. Service name: " + getWebServicename(thisJoinPoint.getTarget().getClass()) + " / Method name: " + thisJoinPoint.getSignature().getName());
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