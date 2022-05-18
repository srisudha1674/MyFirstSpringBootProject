package com.web.application.interceptor;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.web.application.controller.RequestModel;
import com.web.application.exception.UserNotFoundException;
import com.web.application.model.ErrorBean;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class ServiceInterceptor implements HandlerInterceptor {

	@Value("${uservalidation.url}")
	private String userValURL;
	@Value("${loggerapplication.url}")
	private String loggerAppURL;
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
		 
//		Enumeration<String> headers = request.getHeaderNames();
//		String email = "";
//		while(headers.hasMoreElements()){
//		  String headerName = headers.nextElement();
//		  String headerValue = request.getHeader(headerName);
//		  System.out.println("Header Name - "+headerName+", Value	 - " + headerValue);
//		  if(headerName.equals("user-email"))
//		  {
//			  email = headerValue;
//		  }
//		}
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
		String pathinfo = request.getRequestURI();
		String email = request.getHeader("user-email");
		RequestModel reqMod = new RequestModel(email,pathinfo);
		JSONObject logObj = new JSONObject();          
		logObj.put("emailId",email);
		logObj.put("serviceName",pathinfo);
		HttpEntity<String> req = 
			      new HttpEntity<String>(logObj.toString(), headers);
		System.out.println(email);
		System.out.println(pathinfo);
		System.out.println(logObj.toString());
//		ResponseEntity<String>	res = restTemplate.postForEntity(loggerAppURL,logObj.toString(),String.class);
		try {
	//	restTemplate.postForObject(loggerAppURL,reqMod,Void.class);
		ResponseEntity<String>	res = restTemplate.postForEntity(loggerAppURL,req,String.class);
		}
		catch(HttpClientErrorException e){
			//
		}
		catch(HttpServerErrorException e) {
		    //handle 5xx errors
		}

		String url = String.format("%1$s?email_id=%2$s",userValURL,email);
		HttpMethod httpme = HttpMethod.GET;
		ResponseEntity<List> val = restTemplate.exchange(url, httpme,HttpEntity.EMPTY, List.class);
		if (val.getStatusCode() == HttpStatus.OK && val.getBody() != null && !val.getBody().isEmpty()) 
		{
			return true;
		}
		response.setStatus(401);
		if(val.getBody().isEmpty()) {
		throw new UserNotFoundException(new ErrorBean(403,"No user exist with given email Id"));
		}
		return false;
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
