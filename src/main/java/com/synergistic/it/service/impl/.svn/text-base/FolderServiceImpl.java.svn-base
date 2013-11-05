package com.synergistic.it.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.synergistic.it.dao.FolderDao;
import com.synergistic.it.email.spring.form.FolderForm;
import com.synergistic.it.hibernate.entity.FolderEntity;
import com.synergistic.it.service.FolderService;

@Service("FolderServiceImpl")
public class FolderServiceImpl implements FolderService{

	@Autowired
	@Qualifier("FolderDaoImpl")
	private FolderDao folderDao;
	
	@Override
	public boolean addFolder(String userName, String folderName) {
		return folderDao.addFolder(userName, folderName);
	}
	@Override
	public List<FolderForm> findallfolders(String userName) {
		List<FolderEntity> folderEntities = folderDao.findFolders(userName);
		List<FolderForm> folderForms = new ArrayList<FolderForm>();
		for (FolderEntity folderEntity : folderEntities) {
			FolderForm folderForm = new FolderForm();
			BeanUtils.copyProperties(folderEntity, folderForm);
			folderForms.add(folderForm);
		}
		return folderForms;
	}
}
