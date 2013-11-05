package com.synergistic.it.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.synergistic.it.aop.advice.AddMessageBeforeMethod;
import com.synergistic.it.constant.EMailServerConstant;
import com.synergistic.it.dao.CustomerDao;
import com.synergistic.it.hibernate.entity.CustomerEntity;
import com.synergistic.it.hibernate.entity.EmailEntity;
import com.synergistic.it.hibernate.entity.FolderEntity;
import com.synergistic.it.util.DateUtils;

/**
 * <bean id="CustomerDaoImpl" class="com.frog.dao.impl.CustomerDaoImpl">
 * <property name="sessionFactory" ref="psessionFactory"/> </bean>
 * 
 * @author Nagendra
 * 
 */
@Repository("CustomerDaoImpl")
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	
	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory
			.getLog(CustomerDaoImpl.class);
	
	@Autowired
	@Qualifier("psessionFactory")
	public void injectSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public String uploadCustomer(CustomerEntity customerEntity) {
		getHibernateTemplate().save(customerEntity);
		return EMailServerConstant.SUCCESS;
	}

	@Override
	@Transactional(propagation=Propagation.NEVER)
	public CustomerEntity authUser(String username, String password) {
		System.out.println("Is spring transaction is working  = == ? ??? ? "+TransactionSynchronizationManager.isActualTransactionActive());
		List<CustomerEntity> entities = getHibernateTemplate()
				.find("from CustomerEntity as  ce where ce.userid=? and ce.password=?",
						username, password);
		if (entities != null && entities.size() > 0) {
			//return EMailServerConstant.SUCCESS;
			return entities.get(0);
		} else {
			if(logger.isWarnEnabled()){
				logger.warn("user does not exist.");
			}
			return null;
		}
	}

	@Override
	public List<CustomerEntity> findUsers() {
		List<CustomerEntity> entities = getHibernateTemplate().find(
				"from CustomerEntity");
		return entities;
	}

	@Override
	public byte[] findImageByUserId(String userid){		
		List<CustomerEntity> customerEntities=getHibernateTemplate().find("from CustomerEntity as ce where ce.userid=?",userid);
		if(customerEntities!=null  && customerEntities.size()==1){
			return customerEntities.get(0).getPhoto();
		}else{
			if(logger.isWarnEnabled()){
				logger.warn("image is does not exist.");
			}
			return new byte[]{};
		}
	}
	@Override
	public CustomerEntity findUserById(String userid) {
		// TODO Auto-generated method stub
		List<CustomerEntity> entities = getHibernateTemplate().find("from CustomerEntity where userid=?",userid);
		if(entities!=null && entities.size()>0){
			return  entities.get(0);
		}else{
			return  null;
		}
		
		
	}
		
	
	
	@Override
	public String saveCustomer(CustomerEntity customerEntity) {
		  getHibernateTemplate().update(customerEntity);
		  return EMailServerConstant.SUCCESS;
		 
	}
}
