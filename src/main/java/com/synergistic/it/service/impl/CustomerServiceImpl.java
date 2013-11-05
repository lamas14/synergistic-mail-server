package com.synergistic.it.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.synergistic.it.dao.CustomerDao;
import com.synergistic.it.email.spring.form.CustomerForm;
import com.synergistic.it.hibernate.entity.CustomerEntity;
import com.synergistic.it.service.CustomerService;

@Service("CustomerServiceImpl")
@Transactional(propagation=Propagation.REQUIRED)
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
	@Transactional(propagation=Propagation.NEVER)
	public CustomerForm authUser(String username, String password) {
		
		System.out.println("Is spring transaction is working  = == ? ??? ? "+TransactionSynchronizationManager.isActualTransactionActive());
		 CustomerEntity customerEntity=customerDao.authUser(username, password);
		 if(customerEntity==null){
			 return null;
		 }
		 CustomerForm customerForm = new CustomerForm();
		BeanUtils.copyProperties(customerEntity, customerForm);
		return customerForm;
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
	
	@Override
	public String saveCustomer(CustomerForm customerForm) {
		CustomerEntity customerEntity=new CustomerEntity();
		BeanUtils.copyProperties(customerForm, customerEntity);
		String result=customerDao.saveCustomer(customerEntity);
		return result;
	}
	@Override
	public CustomerForm findUserById(String userid) {
		CustomerEntity customerEntity=customerDao.findUserById(userid);
		CustomerForm customerForm= new CustomerForm();
		BeanUtils.copyProperties(customerEntity, customerForm);
		return customerForm;
	}

}
