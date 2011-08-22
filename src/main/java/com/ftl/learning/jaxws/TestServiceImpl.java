package com.ftl.learning.jaxws;

import javax.jws.WebService;

@WebService(serviceName = "testService", name = "testService")
public class TestServiceImpl implements TestService {

	@Override
	public String invert(String text) {

		// if it is empty
		if (text == null || text.trim().length() == 0) {
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

		return sb.toString();
	}

	@Override
	public double[] sumProd(double x, double y) {
		System.out.println("Start service - sumProd");
		double[] retValue = new double[2];

		retValue[0] = x + y;
		retValue[1] = x * y;

		return retValue;
	}
}
