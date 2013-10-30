package com.synergistic.it.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.synergistic.it.dao.FolderDao;
import com.synergistic.it.hibernate.entity.FolderEntity;
import com.synergistic.it.util.DateUtils;

@Repository("FolderDaoImpl")
public class FolderDaoImpl extends HibernateDaoSupport implements FolderDao{
	
	@Autowired
	@Qualifier("psessionFactory")
	public void injectSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean addFolder(String userName, String folderName) {
		List<FolderEntity> folderEntities = getHibernateTemplate().find(
				"from FolderEntity as fe where fe.uName=? and fe.folder=?",
				userName, folderName);
		if (folderEntities != null && folderEntities.size() > 0) {
			return false;
		}else{
			FolderEntity entity = new FolderEntity();
			entity.setFolder(folderName);
			entity.setuName(userName);
			entity.setDoe(DateUtils.getCurrentDateInSQLFormat());
			entity.setDom(DateUtils.getCurrentDateInSQLFormat());
			getHibernateTemplate().save(entity);
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FolderEntity> findFolders(String userName) {
		List<FolderEntity> entities = getHibernateTemplate().find("from FolderEntity as fe where fe.uName=?", userName);
		return entities;
	}

}
