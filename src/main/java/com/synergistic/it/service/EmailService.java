package com.synergistic.it.service;


import java.util.List;

import com.synergistic.it.email.spring.form.EmailForm;
import com.synergistic.it.hibernate.entity.EmailEntity;


public interface EmailService {
	
	 public String uploadSentEmail(EmailForm emailForm);
	 public List<EmailForm> getEmails(String userid, String folderName);
	public void moveEmail(String destFolder, String[] selectedMails, String userid);
	public void deleteEmail(String[] selectedMails, String userid);
	public EmailEntity getEmailEntity(int mAILID, String userid);
}
