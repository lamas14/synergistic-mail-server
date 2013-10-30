package com.synergistic.it.service;

import java.util.List;

import com.synergistic.it.email.spring.form.CustomerForm;

/**
 * 
 * @author Nagendra
 * 
 */
public interface CustomerService {
	public String uploadCustomer(CustomerForm customerForm);
	public String authUser(String username, String password);
	public List<CustomerForm> findUsers();
	
	public byte[] findImageByUserId(String userid);
}
