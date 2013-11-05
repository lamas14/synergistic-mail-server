package com.synergistic.it.dao;

import java.util.List;

import com.synergistic.it.hibernate.entity.ChatEntity;
import com.synergistic.it.hibernate.entity.ChatEntityHistory;

/**
 * 
 * @author yadna01
 *
 */
public interface ChatDao {
	public ChatEntity findChatMessageByUserId(String userid);
	public String pushMessageByUserId(ChatEntity chatEntity);
	public List<ChatEntityHistory> chatList(String userid);
	public List<ChatEntityHistory> showHistory(String ui1, String ui2);	
}
