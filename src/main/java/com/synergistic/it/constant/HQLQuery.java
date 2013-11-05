package com.synergistic.it.constant;

public interface HQLQuery {
	public static final String FIND_CHAT_BY_USERID="from ChatEntity as ce where ce.touser=?";
}
