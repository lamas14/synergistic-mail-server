package com.synergistic.it.service;

import java.util.List;

import com.synergistic.it.email.spring.form.ChatForm;
import com.synergistic.it.hibernate.entity.ChatEntityHistory;

/**
 * 
 * @author yadna01
 *
 */
public interface ChatService {
	public ChatForm findChatMessageByUserId(String userid);	
	public String pushMessageByUserId(ChatForm chatForm);
	public List<ChatEntityHistory> chatList(String userid);
	public List<ChatEntityHistory> showHistory(String ui1, String ui2);	
}
