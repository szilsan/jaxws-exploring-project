package com.ftl.learning.jaxws;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebService(serviceName = "testService", name = "testService")
public class TestServiceImpl implements TestService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestService.class);

	@Override
	public String invert(String text) {

		LOGGER.debug("String to invert: " + text);

		// if it is empty
		if (text == null || text.trim().length() == 0) {
			LOGGER.debug(text == null ? "The text was null" : "Inverted text: " + text);
			return text;
		}

		StringBuilder sb = new StringBuilder();
		for (char c : text.toCharArray()) {
			if (Character.isAlphabetic(c)) {
				if (Character.isUpperCase(c)) {
					c = Character.toLowerCase(c);
				} else {
					c = Character.toUpperCase(c);
				}
			}
			sb.append(c);
		}

		LOGGER.debug("Inverted text: " + sb.toString());
		return sb.toString();
	}

	@Override
	public double[] sumProd(double x, double y) {
		double[] retValue = new double[2];

		retValue[0] = x + y;
		retValue[1] = x * y;

		LOGGER.debug("Result of sumprod: " + x + ", " + y + ". Sum=" + retValue[0] + " Prod: " + retValue[1]);
		return retValue;
	}
}
