package com.ftl.learning.jaxws.aop;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebMethod;
import javax.jws.WebService;


aspect ServiceAspect {

	private final Logger logger = LoggerFactory.getLogger(ServiceAspect.class);

	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private static Validator validator = factory.getValidator();
	
	private static Map<String, Long> methodTakesTime=new HashMap<String, Long>();

	
//	/**
//	 * All java public methods in this project (except tests)
//	 */
//	pointcut allPublicMethods(): execution(public * java..*.*(..)) || execution(public * javax..*(..));
//	
	
	/**
	 * All public methods in this project (except tests)
	 */
//	pointcut publicMethods(): execution(public * com.ftl.learning..*.*(..)) && !execution(* com.ftl.learning.jaxws.service.PrimeTest.*(..));
//
//	/**
//	 * For web services in this project
//	 */
//	pointcut webMethods(Object dto): (execution(@WebMethod * com.ftl.learning..*.*(..)) ||execution(public * (@WebService com.ftl.learning..*).*(..))) && args(dto);
//
//	/**
//	 * For test methods to print statistic
//	 */
//	pointcut testMethods(): execution(* com.ftl.learning.jaxws.service.PrimeTest.*(..)); 
//	
//	before(): publicMethods() {
//		logger.debug("Call ftl method: " + thisJoinPoint.getStaticPart().getSignature());
//	}
//	
//	before(Object dto): webMethods(dto) {
//		logger.debug("Call ftl web service. Service name: " + getWebServicename(thisJoinPoint.getTarget().getClass()) + " / Method name: " + thisJoinPoint.getSignature().getName());
//		validation(dto);
//	}
//	
//	after(): testMethods() {
//		for(Entry<String,Long> entry : methodTakesTime.entrySet() ) {
//	        System.out.println(entry.getKey()+" "+entry.getValue());
//	    }
//	}
	
//	Object around() : publicMethods() || allPublicMethods() {
//		long start, end;
//		start = System.currentTimeMillis();
//		Object ret = proceed();
//		end = System.currentTimeMillis();
//		
//		if (methodTakesTime.containsKey( thisJoinPoint.getStaticPart().getSignature().toShortString())) {
//		    for(Entry<String,Long> entry : methodTakesTime.entrySet() ) {
//		        if( entry.getKey().equals(thisJoinPoint.getStaticPart().getSignature().toShortString()) ) {
//		            entry.setValue(entry.getValue()+(end-start));
//		            break;
//		        }
//		    }
//		} else {
//			methodTakesTime.put(thisJoinPoint.getStaticPart().getSignature().toShortString(), end-start);
//		}
//		
//		return ret;
//	}

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