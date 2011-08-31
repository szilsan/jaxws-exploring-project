package com.ftl.learning.jaxws.filter.shiro;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.Ini;
import org.apache.shiro.util.Factory;
import org.apache.shiro.web.config.WebIniSecurityManagerFactory;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

/**
 * Listener for shiro. Loads the base securityManager.
 */
public class ShiroListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Ini ini = new Ini();
		ini.loadFromPath("classpath:shiro.ini");
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new WebIniSecurityManagerFactory(ini);
		org.apache.shiro.mgt.SecurityManager securityManager = (DefaultWebSecurityManager) factory.getInstance();
		SecurityUtils.setSecurityManager((DefaultWebSecurityManager) securityManager);
	}
}
