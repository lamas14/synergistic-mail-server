package com.synergistic.it.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergistic.it.dao.ChatDao;
import com.synergistic.it.email.spring.form.ChatForm;
import com.synergistic.it.hibernate.entity.ChatEntity;
import com.synergistic.it.hibernate.entity.ChatEntityHistory;
import com.synergistic.it.service.ChatService;

@Service("ChatServiceImpl")
@Transactional(propagation=Propagation.REQUIRED)
public class ChatServiceImpl implements ChatService{
	
	@Autowired
	@Qualifier("ChatDaoImpl")
	private ChatDao chatDao;

	@Override
	public ChatForm findChatMessageByUserId(String userid) {
		ChatEntity chatEntity=chatDao.findChatMessageByUserId(userid);
		ChatForm chatForm=BeanUtils.instantiate(ChatForm.class);
		BeanUtils.copyProperties(chatEntity, chatForm);
		return chatForm;
	}

	@Override
	public String pushMessageByUserId(ChatForm chatForm) {
		ChatEntity chatEntity=BeanUtils.instantiate(ChatEntity.class);
		BeanUtils.copyProperties(chatForm, chatEntity);
		String result=chatDao.pushMessageByUserId(chatEntity);
		return result;
	}

	@Override
	public List<ChatEntityHistory> chatList(String userid) {
		return chatDao.chatList(userid);
	}

	@Override
	public List<ChatEntityHistory> showHistory(String ui1, String ui2) {
		return chatDao.showHistory(ui1,ui2);
	}

}
