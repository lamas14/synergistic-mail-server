package com.synergistic.it.mail.web.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.synergistic.it.email.spring.form.CustomerForm;
import com.synergistic.it.service.CustomerService;

//@WebService says this class is exposed as a web service
@WebService(name="SoapEmailWebService")
@Component("SoapEmailWebServiceImpl")
public class SoapEmailWebServiceImpl implements SoapEmailWebService{
	
	@Autowired
	@Qualifier("CustomerServiceImpl")
	private CustomerService  customerService;

	@Override
	public CustomerFormListWrapper findAllCustomers() {
		List<CustomerForm> customerForms=customerService.findUsers();
		CustomerFormListWrapper customerFormListWrapper=new CustomerFormListWrapper();
		customerFormListWrapper.setCustomerList(customerForms);
		return customerFormListWrapper;
	}

	@Override
	public CustomerForm findCustomerByUserId(String userid) {

		return null;
	}

}
