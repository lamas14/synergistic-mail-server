package com.synergistic.it.email.server.listener;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class UserSessionVO  implements  HttpSessionBindingListener{

	private String userid;
	private String password;
	private String firstName;

	public UserSessionVO() {
		super();
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserSessionVO other = (UserSessionVO) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}


	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "UserSessionVO [userid=" + userid + ", password=" + password
				+ ", firstName=" + firstName + "]";
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
			Set<UserSessionVO> logins = (Set<UserSessionVO>) event.getSession().getServletContext().getAttribute("logins");
			if(logins==null){
				logins=new HashSet<UserSessionVO>();
			}
			logins.add(this);
			event.getSession().getServletContext().setAttribute("logins",logins);
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
	        Set<UserSessionVO> logins = (Set<UserSessionVO>) event.getSession().getServletContext().getAttribute("logins");
	        if(logins!=null)
	        logins.remove(this);
	}
}
