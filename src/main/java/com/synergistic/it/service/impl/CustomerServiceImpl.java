package com.synergistic.it.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.synergistic.it.dao.CustomerDao;
import com.synergistic.it.email.spring.form.CustomerForm;
import com.synergistic.it.hibernate.entity.CustomerEntity;
import com.synergistic.it.service.CustomerService;

@Service("CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	@Qualifier("CustomerDaoImpl")
	private CustomerDao customerDao;

	@Override
	public String uploadCustomer(CustomerForm customerForm) {
		// convert customerForm into customerEntity
		CustomerEntity customerEntity = new CustomerEntity();
		BeanUtils.copyProperties(customerForm, customerEntity);
		String result = customerDao.uploadCustomer(customerEntity);
		return result;
	}

	@Override
	public String authUser(String username, String password) {
		return customerDao.authUser(username, password);
	}

	@Override
	public List<CustomerForm> findUsers() {
		List<CustomerEntity> customerEntities = customerDao.findUsers();
		List<CustomerForm> customerForms = new ArrayList<CustomerForm>();
		for (CustomerEntity customerEntity : customerEntities) {
			CustomerForm customerForm = new CustomerForm();
			BeanUtils.copyProperties(customerEntity, customerForm);
			customerForms.add(customerForm);
		}
		return customerForms;
	}

	@Override
	public byte[] findImageByUserId(String userid) {
		return customerDao.findImageByUserId(userid);
	}
	

}
