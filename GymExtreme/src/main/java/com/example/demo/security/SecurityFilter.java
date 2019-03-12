package com.example.demo.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecurityFilter implements Filter {

	@Autowired
	LoginService loginService;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		 	HttpServletResponse httpResponse = (HttpServletResponse) response;
	        HttpServletRequest httpRequest = (HttpServletRequest) request;

//	        httpResponse.addHeader("Access-Control-Allow-Origin", "*");
//	        httpResponse.addHeader("Access-Control-Allow-Methods", "GET,PUT,PATCH,DELETE,POST,OPTIONS");
//	        httpResponse.addHeader("Access-Control-Max-Age", "3600");
//	        httpResponse.addHeader("Access-Control-Allow-Headers",
//	                "Origin, x-requested-with, token, Content-Type, Accept");
	        
	        String token = httpRequest.getHeader("token");
	        if(httpRequest.getRequestURI().contains("/operator/login") || loginService.checkToken(token)) {
	        	chain.doFilter(request, response);
	        } else {
	        	httpResponse.setStatus(401);
	        }		
	}
}
