package com.ftl.learning.jaxws;

import javax.jws.WebService;

@WebService(serviceName = "testService", name = "testService")
public class TestServiceImpl {

	public double[] sumProd(double x, double y) {
		double[] retValue = new double[2];

		retValue[0] = x * y;
		retValue[1] = x + y;

		return retValue;
	}
}
