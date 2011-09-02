package com.ftl.learning.jaxws.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ftl.learning.logging.LOGMarkers;

public class TestManager {

	private static final Logger logger = LoggerFactory.getLogger(TestManager.class);

	/**
	 * Invert a string.
	 * 
	 * @param text
	 * @return
	 */
	public static String invertString(String text) {
		logger.debug(LOGMarkers.SIMPLE_MARKER, "String to invert: " + text);

		// if it is empty
		if (text == null || text.trim().length() == 0) {
			logger.debug(LOGMarkers.SIMPLE_MARKER, text == null ? "The text was null" : "Inverted text: " + text);
			return text;
		}

		StringBuilder sb = new StringBuilder();
		for (char c : text.toCharArray()) {
			if (Character.isLetter(c)) {
				if (Character.isUpperCase(c)) {
					c = Character.toLowerCase(c);
				} else {
					c = Character.toUpperCase(c);
				}
			}
			sb.append(c);
		}

		logger.debug(LOGMarkers.SIMPLE_MARKER, "Inverted text: " + sb.toString());
		return sb.toString();
	}

	/**
	 * Calculate sumProd.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static double[] sumProd(double x, long y) {
		double[] retValue = new double[2];

		retValue[0] = x + y;
		retValue[1] = x * y;

		logger.debug(LOGMarkers.SIMPLE_MARKER, "Result of sumprod: " + x + ", " + y + ". Sum=" + retValue[0] + " Prod: " + retValue[1]);
		return retValue;
	}
}
