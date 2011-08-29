package com.ftl.learning.jaxws.service;

import javax.xml.ws.BindingProvider;

import com.ftl.learning.jaxws.service.wsclient.InvertDTO;
import com.ftl.learning.jaxws.service.wsclient.SumProdDTO;
import com.ftl.learning.jaxws.service.wsclient.SumProdResponseDTO;
import com.ftl.learning.jaxws.service.wsclient.TestService_Service;

/**
 * Call WS from java client
 * 
 */
public class CallWSTest {

	public static void main(String[] args) {
		TestService_Service testService = new TestService_Service();
		com.ftl.learning.jaxws.service.wsclient.TestService port = testService.getTestServicePort();

		((BindingProvider) port).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "dan");
		((BindingProvider) port).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "123");

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
