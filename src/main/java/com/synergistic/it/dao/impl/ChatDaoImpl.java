package com.synergistic.it.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.synergistic.it.constant.HQLQuery;
import com.synergistic.it.dao.ChatDao;
import com.synergistic.it.hibernate.entity.ChatEntity;
import com.synergistic.it.hibernate.entity.ChatEntityHistory;

@Repository("ChatDaoImpl")
public class ChatDaoImpl extends HibernateDaoSupport implements ChatDao {

	@Autowired
	@Qualifier("psessionFactory")
	public void injectSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public ChatEntity findChatMessageByUserId(String userid) {
		List<ChatEntity> chatEntities = getHibernateTemplate().find(
				HQLQuery.FIND_CHAT_BY_USERID, userid);
		if (chatEntities != null && chatEntities.size() > 0) {
			ChatEntity chatEntity = chatEntities.get(0);
			ChatEntityHistory chatEntityHistory = new ChatEntityHistory();
			BeanUtils.copyProperties(chatEntity, chatEntityHistory);
			getHibernateTemplate().save(chatEntityHistory);
			getHibernateTemplate().delete(chatEntity);
			System.out.println(chatEntity);
			return chatEntity;
		}
		// returning black object
		return new ChatEntity();
	}

	@Override
	public String pushMessageByUserId(ChatEntity chatEntity) {
		getHibernateTemplate().save(chatEntity);
		return "done";
	}

	@Override
	public List<ChatEntityHistory> chatList(String userid) {
		//From user is User 
		List<ChatEntityHistory> userList1 = getHibernateTemplate().find("from ChatEntityHistory as ce where ce.fromuser=? group by ce.touser", userid);
		//TO user is user
		List<ChatEntityHistory> userList2 = getHibernateTemplate().find("from ChatEntityHistory as ce where ce.touser=? group by ce.fromuser", userid);

		List<ChatEntityHistory> userList = new ArrayList<ChatEntityHistory>();
		userList.addAll(userList1);
		
		boolean same = false;
		for (ChatEntityHistory ceh : userList2) {
			for (ChatEntityHistory ceh1 : userList1) {
				if(ceh.getFromuser().equals(ceh1.getTouser())){
					same = true;
				}
			}
			if(!same){
				userList.add(ceh);
			}
			same=false;
		}
		
		return userList;
	}

	@Override
	public List<ChatEntityHistory> showHistory(String ui1, String ui2) {
		List<ChatEntityHistory> chatHistory = getHibernateTemplate().find("from ChatEntityHistory as ce where (ce.touser=? and ce.fromuser=?) or (ce.fromuser=? and ce.touser=?)", ui1,ui2,ui1,ui2);
		return chatHistory;
	}

}
