package com.ftl.learning.jaxws.service;

import com.ftl.learning.jaxws.service.wsclient.InvertDTO;
import com.ftl.learning.jaxws.service.wsclient.TestService_Service;

/**
 * Call WS from java client
 * 
 */
public class CallWSTest {

	public static void main(String[] args) {
		TestService_Service testService = new TestService_Service();
		com.ftl.learning.jaxws.service.wsclient.TestService port = testService.getTestServicePort();

		InvertDTO invertDTO = new InvertDTO();
		invertDTO.setInputString("korte");
		String invertResponse = port.invert(invertDTO);
		assert (invertResponse.equals("KORTE"));
		System.out.println("aabb");
	}
}
