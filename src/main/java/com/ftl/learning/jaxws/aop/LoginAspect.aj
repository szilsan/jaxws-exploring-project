import java.util.logging.LogManager;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.subject.support.WebDelegatingSubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ftl.learning.jaxws.filter.LOGMarkers;
import com.ftl.learning.jaxws.service.TestServiceImpl;

aspect LoginAspect {
	private final Logger logger = LoggerFactory.getLogger(LoginAspect.class);
	
	
	pointcut webMethods(Object dto): ((execution(@WebMethod * com.ftl.learning..*.*(..)) || execution(public * (@WebService com.ftl.learning..*).*(..))) && args(dto)) && !execution(public * com.ftl.learning.jaxws.filter*.*(..));

	before(Object dto): webMethods(dto) {
		WebServiceContext wsc = ((TestServiceImpl)thisJoinPoint.getTarget()).getWsCtxt();
		HttpServletRequest request = (HttpServletRequest) wsc.getMessageContext().get(MessageContext.SERVLET_REQUEST);
        if ("WSDL".equalsIgnoreCase(request.getQueryString())) {
        	logger.debug(LOGMarkers.SIMPLE_MARKER,"Authenticate user. Simple WSDl query." );
        } else {
        	logger.debug(LOGMarkers.SIMPLE_MARKER,"Authenticate user." + ((TestServiceImpl)thisJoinPoint.getTarget()).getWsCtxt());
        	logger.debug(LOGMarkers.SIMPLE_MARKER, SecurityUtils.getSecurityManager().getClass().toString());
        	Subject currentUser = SecurityUtils.getSubject();
        	AuthenticationToken token = new UsernamePasswordToken("dan", "123");
        	((UsernamePasswordToken)token).setRememberMe(false);
        	((DefaultWebSecurityManager)SecurityUtils.getSecurityManager()).login(currentUser, token);
        }
		
		
	}
}