package com.ftl.learning.jaxws.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

aspect LoggingAspect {

	private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	/**
	 * All public methods in this project (except tests)
	 */
	pointcut publicMethods(): execution(public * com.ftl.learning..*.*(..)) && !execution(* com.ftl.learning.jaxws.service.PrimeTest.*(..));
	
	before(): publicMethods() {
		logger.debug("Call ftl method: " + thisJoinPoint.getStaticPart().getSignature());
	}
}