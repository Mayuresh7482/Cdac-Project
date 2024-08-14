package com.foodwastage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class RequestFilter implements Filter  {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		String requestedUri=req.getRequestURI();
		if(requestedUri.matches(".*(css|jpg|png|gif|js)") || requestedUri.matches("[/](login|about|contact|register|aregister|mission|)")){
		    chain.doFilter(request, response);
		    return;
		}else {
			HttpSession session=req.getSession();
			System.out.println("Checking your request "+req.getRequestURI());
			if(session.getAttribute("user")!=null) {
				chain.doFilter(request, response);
			}else {
				HttpServletResponse resp=(HttpServletResponse) response;
				resp.sendRedirect("/login");		
			}
		}
	}

}
