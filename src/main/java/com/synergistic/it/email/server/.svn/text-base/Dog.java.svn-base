package com.synergistic.it.email.server;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//<bean id="dog"  class=" com.synergistic.it.email.server.Dog"/>

@Component("dog")
@Scope("singleton")
public class Dog {
	private String name = "tommy";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + "]";
	}

}
