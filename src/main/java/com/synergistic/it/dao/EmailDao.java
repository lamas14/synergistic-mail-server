package com.synergistic.it.dao;

import java.util.List;

import com.synergistic.it.hibernate.entity.EmailEntity;

public interface EmailDao {
	public String uploadEmails(EmailEntity emailEntity);
	public List<EmailEntity> findEmails(String userid, String folderName, int page);
	public void moveEmails(String destFolder, String[] selectedMails, String userid);
	public void deleteEmails(String[] selectedMails, String userid);
	public EmailEntity getEmail(int mAILID, String userid);
}
