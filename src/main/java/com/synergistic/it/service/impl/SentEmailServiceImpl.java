package com.synergistic.it.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.synergistic.it.dao.EmailDao;
import com.synergistic.it.email.spring.form.SentEmailForm;
import com.synergistic.it.hibernate.entity.EmailEntity;
import com.synergistic.it.service.SentEmailService;


@Service("SentEmailServiceImpl")
public class SentEmailServiceImpl implements SentEmailService{

	
	@Autowired
	@Qualifier("EmailDaoImpl")
	private EmailDao emailDao;
	
	@Override
	public String uploadSentEmail(SentEmailForm sentEmailForm) {
		//convert customerForm into customerEntity
				EmailEntity emailEntity=new EmailEntity();
				BeanUtils.copyProperties(sentEmailForm, emailEntity);
				String result=emailDao.uploadEmails(emailEntity);
				return result;	}

}
