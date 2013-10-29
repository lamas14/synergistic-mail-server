package com.synergistic.it.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

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
	public String authUser(String username, String password) {
		List<CustomerEntity> entities = getHibernateTemplate()
				.find("from CustomerEntity as  ce where ce.userid=? and ce.password=?",
						username, password);
		if (entities != null && entities.size() > 0) {
			return EMailServerConstant.SUCCESS;
		} else {
			return EMailServerConstant.FAILURE;
		}
	}

	@Override
	public List<CustomerEntity> findUsers() {
		List<CustomerEntity> entities = getHibernateTemplate().find(
				"from CustomerEntity");
		return entities;
	}

}
