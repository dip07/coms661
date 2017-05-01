/**
 * 
 */
package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author dipanjankarmakar
 *
 */
public class LoggingInterceptor extends HandlerInterceptorAdapter
{
	
	@Value("${sessionTimeOut}")
	private Integer sessionTimeOut;
	
	private static final Logger logger = Logger.getLogger(LoggingInterceptor.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception 
	{
		String url="";
		try{
		url = request.getRequestURL().toString() + "?" + request.getQueryString();
		//logger.warn("Url >> " + url);
		
		}
		catch(Exception e)
		{
			logger.error("Error while fetching url " + e.getMessage(),e);
		}
		
		String userNetId = null;
		try{
			userNetId = request.getSession().getAttribute("bookUserNetId").toString();
		}
		catch(NullPointerException e)
		{
			logger.error("NPE while fetching userId");
			response.sendRedirect(request.getContextPath());
			return false;

		}
		catch(Exception e)
		{
			logger.error("Error while fetching user netId " + e.getStackTrace(), e);
			response.sendRedirect(request.getContextPath());
			return false;

		}
		if(userNetId == null || userNetId.isEmpty())
		{
			response.sendRedirect(request.getContextPath());
		}
		logger.warn("UserId " + userNetId + " url visited : " + url);
		request.getSession().setMaxInactiveInterval(sessionTimeOut*60);
		return true;
	}

}
