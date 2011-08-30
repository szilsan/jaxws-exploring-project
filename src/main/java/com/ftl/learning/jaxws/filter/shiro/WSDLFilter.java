package com.ftl.learning.jaxws.filter.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;

/**
 * Filter wsdls. WSDL request does not need authentication.
 * 
 */
public class WSDLFilter extends BasicHttpAuthenticationFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		// WSDL is OK
		if (((HttpServletRequest) request).getQueryString() != null
				&& ((HttpServletRequest) request).getQueryString().equalsIgnoreCase("WSDL")) {
			return true;
		}
		return super.onAccessDenied(request, response);
	}
}
