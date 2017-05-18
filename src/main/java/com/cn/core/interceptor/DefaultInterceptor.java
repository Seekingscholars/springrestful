package com.cn.core.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cn.core.config.Config;
import com.cn.core.utils.AjaxResult;
import com.cn.core.utils.WebUtils;
/**
 * 安全拦截器 
 * @author mjl
 */
public class DefaultInterceptor extends HandlerInterceptorAdapter {
	static Logger logger = Logger.getLogger(DefaultInterceptor.class.getName());
	/**
	 * 配置：不拦截的servlet请求
	 */
	private static final String filter[] = {
		Config.getAttribute("filter")
	};
	/**
	 * 拦截规则
	 * 判断当前uri是否在不拦截的servlet中.
	 * 	yes : 放行
	 *  no  : 判断下一步规则
	 */
	private boolean isAllow(String uri) {
		for (String r : filter) {
			if(uri.endsWith(r))
				return true;
		}
		return false;
	}
	/**
	 * 处理类
	 * 拦截成功后.重定向.指向新的url
	 */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	String uri = request.getRequestURI();
    	logger.info("DefaultSecurityInterceptor " + uri);
    	if (this.isAllow(uri))
    		return true;
    	
    	if (request.getSession() == null || request == null) {
    		if (WebUtils.isAjaxRequest(request)) {
	        	WebUtils.responseJson(response, AjaxResult.warpError("用户会话已失效，请重新登录！"));
    		} else {
                request.getRequestDispatcher("/forward").forward(request, response);
    		}
            return false;
        }
        return true;
    }
}
