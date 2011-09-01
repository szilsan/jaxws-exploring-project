package com.ftl.learning.jaxws.aop;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


aspect MethodWatcherAspect {

	private final Logger logger = LoggerFactory.getLogger(MethodWatcherAspect.class);
	private static Map<String, Long> methodTakesTime=new HashMap<String, Long>();

	/**
	 * All public methods in this project (except tests)
	 */
	pointcut publicMethods(Object[] arg): (execution(public * com.ftl.learning..*.*(*)) && !execution(* com.ftl.learning.jaxws.service.PrimeTest.*(*)) && args(arg)) && !execution(public * com.ftl.learning.jaxws.filter..*.*(..));

	/**
	 * For test methods to print statistic
	 */
	pointcut testMethods(): execution(* com.ftl.learning.jaxws.service.PrimeTest.*(..)); 
	
	after(): testMethods() {
		for(Entry<String,Long> entry : methodTakesTime.entrySet() ) {
	        System.out.println(entry.getKey()+" "+entry.getValue());
	    }
	}
	
	Object around(Object[] arg) : publicMethods(arg) {
		long start, end;
		start = System.currentTimeMillis();
		Object ret = proceed(arg);
		end = System.currentTimeMillis();
		
		if (methodTakesTime.containsKey( thisJoinPoint.getStaticPart().getSignature().toShortString())) {
		    for(Entry<String,Long> entry : methodTakesTime.entrySet() ) {
		        if( entry.getKey().equals(thisJoinPoint.getStaticPart().getSignature().toShortString()) ) {
		            entry.setValue(entry.getValue()+(end-start));
		            break;
		        }
		    }
		} else {
			methodTakesTime.put(thisJoinPoint.getStaticPart().getSignature().toShortString(), end-start);
		}
		
		return ret;
	}

}