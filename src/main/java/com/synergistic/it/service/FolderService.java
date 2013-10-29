package com.synergistic.it.service;

import java.util.List;

import com.synergistic.it.email.spring.form.FolderForm;

public interface FolderService {
	public boolean addFolder(String userName, String folderName);
	public List<FolderForm> findallfolders(String userName);
}
