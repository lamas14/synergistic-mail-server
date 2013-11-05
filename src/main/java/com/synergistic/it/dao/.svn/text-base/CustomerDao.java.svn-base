package com.synergistic.it.dao;

import java.util.List;

import com.synergistic.it.hibernate.entity.CustomerEntity;
import com.synergistic.it.hibernate.entity.EmailEntity;
import com.synergistic.it.hibernate.entity.FolderEntity;

/**
 * 
 * @author Nagendra
 * 
 */
public interface CustomerDao {
	public String uploadCustomer(CustomerEntity customerEntity);

	public CustomerEntity authUser(String username, String password);

	public List<CustomerEntity> findUsers();

	public byte[] findImageByUserId(String userid);
	
	public String saveCustomer(CustomerEntity customerEntity);
	 
	public CustomerEntity findUserById(String userid);
}
