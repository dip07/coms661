/**
 * 
 */
package com.interceptor;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author dipanjankarmakar
 *
 */
public class LoggingInterceptor extends HandlerInterceptorAdapter
{
	private static final Logger logger = Logger.getLogger(LoggingInterceptor.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception 
	{

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
		logger.warn("UserId " + userNetId + " logged during time " + LocalDateTime.now());
		request.getSession().setMaxInactiveInterval(5*60);
		return true;
	}

}
