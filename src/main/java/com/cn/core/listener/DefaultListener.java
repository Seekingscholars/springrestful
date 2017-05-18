package com.cn.core.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
/**
 * 监听器
 * @author mjl
 */
public class DefaultListener implements ServletContextListener {
	static Logger logger = Logger.getLogger(DefaultListener.class.getName());
	@Override
	public void contextInitialized(ServletContextEvent event) {
//		Config.cacheConfig("application");
//		RequestUtil.setWebappsDir(event.getServletContext());
		logger.info("ServletContextEvent 信息 " + event.toString());
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.gc();
	}
}
