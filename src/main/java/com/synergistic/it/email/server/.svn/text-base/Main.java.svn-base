package com.synergistic.it.email.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("test-conf.xml");
		Master master=(Master)applicationContext.getBean("master");
		System.out.println(master);
		
	}

}
