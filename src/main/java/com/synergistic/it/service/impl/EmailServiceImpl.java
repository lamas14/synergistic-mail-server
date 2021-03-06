package com.synergistic.it.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.synergistic.it.dao.EmailDao;
import com.synergistic.it.email.spring.form.EmailForm;
import com.synergistic.it.hibernate.entity.EmailEntity;
import com.synergistic.it.service.EmailService;

@Service("EmailServiceImpl")
public class EmailServiceImpl implements EmailService {

	@Autowired
	@Qualifier("EmailDaoImpl")
	private EmailDao emailDao;

	@Override
	public String uploadSentEmail(EmailForm emailForm) {
		// convert customerForm into customerEntity
		EmailEntity emailEntity = new EmailEntity();
		BeanUtils.copyProperties(emailForm, emailEntity);
		String result = emailDao.uploadEmails(emailEntity);
		return result;
	}

	@Override
	public List<EmailForm> getEmails(String userid, String folderName,
			int page) {
		List<EmailEntity> emailEntities = emailDao.findEmails(userid,
				folderName, page);
		List<EmailForm> emailForms = new ArrayList<EmailForm>();
		if (emailEntities != null) {
			for (EmailEntity emailEntity : emailEntities) {
				EmailForm ef = new EmailForm();
				BeanUtils.copyProperties(emailEntity, ef);
				emailForms.add(ef);
			}
		}
		return emailForms;
	}

	@Override
	public void moveEmail(String destFolder, String[] selectedMails,
			String userid) {
		emailDao.moveEmails(destFolder, selectedMails, userid);
	}

	@Override
	public void deleteEmail(String[] selectedMails, String userid) {
		emailDao.deleteEmails(selectedMails, userid);
	}

	@Override
	public EmailEntity getEmailEntity(int mAILID, String userid) {
		EmailEntity emailEntity = emailDao.getEmail(mAILID, userid);
		return emailEntity;
	}

}
