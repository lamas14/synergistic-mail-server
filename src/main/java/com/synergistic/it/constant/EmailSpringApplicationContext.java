package com.synergistic.it.constant;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Deprecated
public class EmailSpringApplicationContext {
	
	private static ApplicationContext applicationContext=new ClassPathXmlApplicationContext("soap-email-server-application-context.xml");

	static public Object getSpringBean(String beanName){
		return applicationContext.getBean(beanName);
	}

}
