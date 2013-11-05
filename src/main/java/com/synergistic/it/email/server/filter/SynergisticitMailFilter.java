package com.synergistic.it.email.server.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.synergistic.it.constant.SpringMvcNavigationCont;

/**
 * Servlet Filter implementation class DesiBankFilter
 */
public class SynergisticitMailFilter implements Filter {

	private Set<String> allowedUrls=new HashSet<String>();
	public void init(FilterConfig fConfig) throws ServletException {
		String allowAccess=fConfig.getServletContext().getInitParameter("allowAccess");
		String aurls[]=allowAccess.split(",");
		//I have added array into set
		allowedUrls.addAll(Arrays.asList(aurls));
	}

	public void destroy() {
	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request2=(HttpServletRequest)request;
		String url=request2.getServletPath();
		//System.out.println("Request2= "+url);
		if(allowedUrls.contains(url) ) {
			chain.doFilter(request, response);	///Go to requested resource no need to validate session
		} else{
		    HttpSession session=request2.getSession(false);
		    if(session!=null && session.getAttribute(SpringMvcNavigationCont.USER_ID)!=null){
				chain.doFilter(request, response);///Go to requested resource no need to validate session	
		    } else{
		    
		    	//System.out.println("YYY= "+request2.getContextPath()+"/login.htm");
		    	HttpServletResponse response2 = (HttpServletResponse)response;
		    	String path=request2.getContextPath();
		    	response2.sendRedirect(path+"/auth/sessionTimeOut.htm?error=Your session is time out, please log in once again");
		    	 //request2.getSession().getServletContext().getRequestDispatcher("/login.htm").forward(request, response);
		    }
		}
	}

	
}
