package com.series.hellocontroller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {


	@Override
	public boolean preHandle(HttpServletRequest reqeust,
			HttpServletResponse response, Object handler) throws Exception {
		
		Calendar cal = Calendar.getInstance();
		
		int dayOfWeek = cal.get(cal.DAY_OF_WEEK); // getting day on which request is made.
		
		if(dayOfWeek == 1) { //1 means Sunday, 2 = monday....
			
			response.getWriter().write("The website is closed on sundays; please try accessing it " + 
					"on any other week day!!");
			
			return false;
		}
		
		
		//if this method return true then - application will further handle the request
		//if this method return false then - application will not further handle request.
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("HandlerInterceptorAdaptor: Spring MVC called postHandle method for " +
					request.getRequestURI().toString());
		
		//this method will be called after Spring MVC executes the request handler method for the request.
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
		System.out.println("HandlerInterceptorAdaptor: Spring MVC called afterCompletion method for " +
				request.getRequestURI().toString());
	
		//this method will be called after response object is produced by the view for the request.
	}
	
	
	
}
