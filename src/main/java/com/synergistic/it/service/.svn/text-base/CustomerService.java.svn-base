package com.synergistic.it.service;

import java.util.List;

import com.synergistic.it.email.spring.form.CustomerForm;
import com.synergistic.it.email.spring.form.EmailForm;
import com.synergistic.it.email.spring.form.FolderForm;
import com.synergistic.it.hibernate.entity.CustomerEntity;

/**
 * 
 * @author Nagendra
 * 
 */
public interface CustomerService {
	public String uploadCustomer(CustomerForm customerForm);
	public CustomerForm authUser(String username, String password);
	public List<CustomerForm> findUsers();
	public String saveCustomer(CustomerForm customerForm);
	public CustomerForm findUserById(String userid);
	
	public byte[] findImageByUserId(String userid);
}
