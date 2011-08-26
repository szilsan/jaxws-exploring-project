package com.ftl.learning.jaxws.aop;

import java.lang.annotation.Annotation;

import javax.jws.WebService;

/**
 * Ut5il class for aspects
 * 
 * @author szilsan
 * 
 */
public class AspectUtil {
	/**
	 * If class is a webservice returns it's name.
	 * 
	 * @param c
	 * @return
	 */
	public static String getWebServicename(Class c) {
		Annotation[] annotations = c.getAnnotations();
		if (annotations.length == 0) {
			return "";
		}

		for (Annotation a : annotations) {
			if (a instanceof WebService) {
				return ((WebService) a).serviceName();
			}
		}
		return "";
	}
}
