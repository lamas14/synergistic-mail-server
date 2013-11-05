package com.synergistic.it.email.server.listener;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

import com.synergistic.it.constant.EMailServerConstant;

/**
 * 
 * @author yadna01
 *
 */
public class UserSessionListener implements HttpSessionBindingListener{
	
	private Set<UserSessionVO> logins; 
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		if(logins==null){
			logins=new HashSet<UserSessionVO>();
		}
		HttpSession session=event.getSession();
		UserSessionVO sessionVO=(UserSessionVO)session.getAttribute(EMailServerConstant.USER_SESSION_VO);
		if(sessionVO!=null){
			logins.add(sessionVO);
			event.getSession().getServletContext().setAttribute("logins",logins);
		}	
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		HttpSession session=event.getSession();
		UserSessionVO sessionVO=(UserSessionVO)session.getAttribute("userSessionVOs");
	    if (sessionVO != null) {
	        Set<UserSessionVO> logins = (Set<UserSessionVO>) event.getSession().getServletContext().getAttribute("logins");
	        logins.remove(sessionVO);
	    }
	}
}
