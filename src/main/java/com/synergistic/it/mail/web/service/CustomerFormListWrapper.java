package com.synergistic.it.mail.web.service;

import java.util.List;

import com.synergistic.it.email.spring.form.CustomerForm;

public class CustomerFormListWrapper {

	private List<CustomerForm> customerList;

	public List<CustomerForm> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<CustomerForm> customerList) {
		this.customerList = customerList;
	}

	@Override
	public String toString() {
		return "CustomerFormListWrapper [customerList=" + customerList + "]";
	}
}
