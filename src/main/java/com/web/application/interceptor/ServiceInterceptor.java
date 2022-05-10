package com.web.application.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class ServiceInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
		throws Exception {
		System.out.println("in preHandle");
		log.error("interceptor error");
		log.info("interceptor info print");
		log.trace("interceptor trace print");
		log.debug("interceptor debug print");
		log.warn("interceptor warn print");
		Enumeration<String> params = request.getParameterNames();
		while(params.hasMoreElements()){
		  String paramName = params.nextElement();
		  System.out.println("Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
		}
		Enumeration<String> attri = request.getAttributeNames();
		while(attri.hasMoreElements()){
		  String attriName = attri.nextElement();
		  System.out.println("Atribute Name - "+attriName+", Value	 - "+request.getAttribute(attriName));
		}
		
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()){
		  String headerName = headers.nextElement();
		  System.out.println("Header Name - "+headerName+", Value	 - "+request.getHeader(headerName));
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	//	HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		System.out.println("in post handle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
	//	HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
		System.out.println(" in after completion");
	}
	


}
