package com.synergistic.it.dao;

import java.util.List;

import com.synergistic.it.hibernate.entity.CustomerEntity;
import com.synergistic.it.hibernate.entity.FolderEntity;

/**
 * 
 * @author Nagendra
 * 
 */
public interface CustomerDao {
	public String uploadCustomer(CustomerEntity customerEntity);

	public String authUser(String username, String password);

	public List<CustomerEntity> findUsers();

	public boolean addFolder(String userName, String folderName);

	public List<FolderEntity> findFolders(String userName);
}
