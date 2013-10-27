package com.synergistic.it.email.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("master")
public class Master {
 
/*
  <bean id="master" class="com.synergistic.it.email.server.Master">
	<property name="dog" ref="dog"/>
</bean>
*/	
	
@Autowired
@Qualifier("dog")//ref="dog"
private Dog dog;
   

public Dog getDog() {
	return dog;
}



public void setDog(Dog dog) {
	this.dog = dog;
}



@Override
public String toString() {
	return "Master [dog=" + dog + "]";
}
   
}
