package com.spring.SocialSphere.services;

import java.util.List;

import com.spring.SocialSphere.exception.ChatException;
import com.spring.SocialSphere.models.Chat;
import com.spring.SocialSphere.models.User;

public interface ChatService {

	public Chat createChat(User reqUser,User user2);
	
	public Chat findChatById(Integer chatId) throws ChatException;
	
	public List<Chat> findAllChatByUserId(Integer userId);
}
