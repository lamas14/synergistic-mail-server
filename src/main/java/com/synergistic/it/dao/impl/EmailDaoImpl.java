package com.synergistic.it.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.synergistic.it.constant.EMailServerConstant;
import com.synergistic.it.dao.EmailDao;
import com.synergistic.it.hibernate.entity.EmailEntity;
import com.synergistic.it.hibernate.entity.SentEmailEntity;

@Repository("EmailDaoImpl")
public class EmailDaoImpl extends HibernateDaoSupport implements EmailDao {

	@Autowired
	@Qualifier("psessionFactory")
	public void injectSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public String uploadEmails(EmailEntity emailEntity) {
		getHibernateTemplate().save(emailEntity);
		SentEmailEntity saveEmailEntity = new SentEmailEntity();
		BeanUtils.copyProperties(emailEntity, saveEmailEntity);
		saveEmailEntity.setFOLDER("Send_Item");
		getHibernateTemplate().save(saveEmailEntity);
		return EMailServerConstant.SUCCESS;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmailEntity> findEmails(String userid, String folderName, int page) {
		
		List<EmailEntity> entities = new ArrayList<EmailEntity>();
		List<SentEmailEntity> sentEmailEntities = new ArrayList<SentEmailEntity>();
		int startIndex = 10*page;
		int endIndex = startIndex +10;
		/*
		 * Checking Sent Emails Table Match Condition: from== userid and
		 * folderName == clicked folder
		 */
		sentEmailEntities = getHibernateTemplate()
				.find("from SentEmailEntity as ee where ee.MAILFROM=? and ee.FOLDER=?",
						userid, folderName);
		if (folderName.equals("Send_Item")) {
			if(sentEmailEntities.size()<startIndex){
				return null;
			}
			if(sentEmailEntities.size()<endIndex){
				endIndex = sentEmailEntities.size();
			}
			for (SentEmailEntity sentEmailEntity : sentEmailEntities) {
				EmailEntity emailEntity = new EmailEntity();
				BeanUtils.copyProperties(sentEmailEntity, emailEntity);
				entities.add(emailEntity);
			}
		}
		/*
		 * Checking Other Folders Match Condition: To == userid and folderName
		 * == Clicked folder
		 */
		else {
			entities = getHibernateTemplate().find(
					"from EmailEntity as ee where ee.MAILTO=? and ee.FOLDER=? or ee.MAILFROM=? and ee.FOLDER=?",
					userid, folderName, userid, "Send_Item");
			
			if(entities.size()<startIndex){
				return null;
			}
			if(entities.size()<endIndex){
				endIndex = entities.size();
			}
			
		}
		return entities.subList(startIndex, endIndex);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void moveEmails(String destFolder, String[] selectedMails,
			String userid) {
		int length = selectedMails.length;
		int current;
		for (int i = 0; i < length; i++) {
			current = Integer.parseInt(selectedMails[i]);
			
			/*
			 * Checking Folders except sent items folder
			 * Match condition: Mail To == userid and MailID = selected Mail's id
			 * Post-Condition: change Folder Name to destFolder
			 */
			List<EmailEntity> entities = (List<EmailEntity>) getHibernateTemplate()
					.find("from EmailEntity as ee where ee.MAILID=? and ee.MAILTO=?",
							current, userid);
			entities.addAll(getHibernateTemplate().find("from EmailEntity as ee where ee.MAILID=? and ee.MAILFROM=?", current, userid));
			if (entities != null && entities.size() > 0) {
				entities.get(0).setFOLDER(destFolder);
				getHibernateTemplate().update(entities.get(0));
			}
			
			/*
			 * Checking Sent Emails Table
			 * Match condition: Mail From == userid and MailID = selected Mail's id
			 * Post-Condition: change Folder Name to destFolder
			 */
			List<SentEmailEntity> sentEmailEntities = (List<SentEmailEntity>) getHibernateTemplate()
					.find("from SentEmailEntity as ee where ee.MAILID=? and ee.MAILFROM=?",
							current, userid);
			if (sentEmailEntities != null && sentEmailEntities.size() > 0) {
				EmailEntity entity = new EmailEntity();
				sentEmailEntities.get(0).setFOLDER("Send_Item");
				BeanUtils.copyProperties(sentEmailEntities.get(0), entity);
				getHibernateTemplate().save(entity);
				getHibernateTemplate().delete(sentEmailEntities.get(0));
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteEmails(String[] selectedMails, String userid) {
		int length = selectedMails.length;
		int current;
		for (int i = 0; i < length; i++) {
			current = Integer.parseInt(selectedMails[i]);
			/*
			 * Checking Folders except sent items folder
			 * Match condition: Mail To == userid and MailID = selected Mail's id
			 * Post-Condition: Delete email from Table
			 */
			List<EmailEntity> entities = (List<EmailEntity>) getHibernateTemplate()
					.find("from EmailEntity as ee where ee.MAILID=? and ee.MAILTO=?",
							current, userid);
			if (entities != null && entities.size() > 0) {
				getHibernateTemplate().delete(entities.get(0));
			}
			
			/*
			 * Checking Sent Emails Table
			 * Match condition: Mail From == userid and MailID = selected Mail's id
			 * Post-Condition: Delete email from table
			 */
			List<SentEmailEntity> sentEmailEntities = (List<SentEmailEntity>) getHibernateTemplate()
					.find("from SentEmailEntity as ee where ee.MAILID=? and ee.MAILFROM=?",
							current, userid);
			if (sentEmailEntities != null && sentEmailEntities.size() > 0) {
				getHibernateTemplate().delete(sentEmailEntities.get(0));
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public EmailEntity getEmail(int mAILID, String userid) {
		/*
		 * Checking Other Folders 
		 * Match Condition: To == userid and Mail ID == Selected Mail's ID
		 */
		List<EmailEntity> entities = (List<EmailEntity>) getHibernateTemplate()
				.find("from EmailEntity as ee where ee.MAILID=? and ee.MAILTO=?",
						mAILID, userid);
		if (entities != null && entities.size() > 0) {
			return entities.get(0);
		}
		/*
		 * Checking Sent Emails Table 
		 * Match Condition: From == userid and Mail ID == Selected Mail's ID
		 */
		List<SentEmailEntity> sentEmailEntities = (List<SentEmailEntity>) getHibernateTemplate()
				.find("from SentEmailEntity as ee where ee.MAILID=? and ee.MAILFROM=?",
						mAILID, userid);
		EmailEntity emailEntity = new EmailEntity();
		BeanUtils.copyProperties(sentEmailEntities.get(0), emailEntity);
		return emailEntity;
	}

}
