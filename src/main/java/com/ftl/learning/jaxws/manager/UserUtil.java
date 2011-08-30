package com.ftl.learning.jaxws.manager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

public class UserUtil {

	@Resource
	private static WebServiceContext wsContext;

	public static void login() {
		MessageContext msgContext = wsContext.getMessageContext();
		HttpServletRequest request = (HttpServletRequest) msgContext.get(MessageContext.SERVLET_REQUEST);
		HttpSession session = request.getSession();
	}
}
