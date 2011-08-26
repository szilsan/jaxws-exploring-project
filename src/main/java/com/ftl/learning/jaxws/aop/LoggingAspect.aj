package com.ftl.learning.jaxws.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ftl.learning.jaxws.filter.LOGMarkers;

aspect LoggingAspect {

	private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	/**
	 * All public methods in this project (except tests)
	 */
	pointcut publicMethods(): execution(public * com.ftl.learning..*.*(..)) && !execution(public * com.ftl.learning.jaxws.filter..*.*(..));
	
	before(): publicMethods() {
		logger.debug(LOGMarkers.BUSINESS_MARKER, "Call ftl method: " + thisJoinPoint.getStaticPart().getSignature());
	}
}