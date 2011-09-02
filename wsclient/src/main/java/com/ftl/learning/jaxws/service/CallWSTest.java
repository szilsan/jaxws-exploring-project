package com.ftl.learning.jaxws.service;

import com.ftl.learning.jaxws.service.wsclient.InvertDTO;
import com.ftl.learning.jaxws.service.wsclient.SumProdDTO;
import com.ftl.learning.jaxws.service.wsclient.SumProdResponseDTO;
import com.ftl.learning.jaxws.service.wsclient.TestService_Service;

/**
 * Call WS from java client
 * 
 */
public class CallWSTest {

	public static String urlUsecamel = "";

	public static void main(String[] args) {

		// help
		System.out
				.println("Use -DuseCamel=[yes|no] to enable to connect Apache Camel. Default value is YES. The difference is only in port [8080|9080].");

		String useCamel = System.getProperties().getProperty("useCamel");
		if ("NO".equalsIgnoreCase(useCamel)) {
			urlUsecamel = "http://localhost:8080/business_server/testService?wsdl";
		} else {
			urlUsecamel = "http://localhost:9080/business_server/testService?wsdl";
		}

		TestService_Service testService = new TestService_Service();
		com.ftl.learning.jaxws.service.wsclient.TestService port = testService.getTestServicePort();

		InvertDTO invertDTO = new InvertDTO();
		invertDTO.setInputString("korte");
		String invertResponse = port.invert(invertDTO);
		assert (invertResponse.equals("KORTE"));

		SumProdDTO sumProdDTO = new SumProdDTO();
		sumProdDTO.setX(-4);
		sumProdDTO.setY(7);
		SumProdResponseDTO resp = port.sumProd(sumProdDTO);
		assert (resp.getSum() == 3);
		assert (resp.getSum() == -28);

		System.out.println("WS test end");
	}
}
