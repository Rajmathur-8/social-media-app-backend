package com.spring.SocialSphere.services;

import java.util.List;

import com.spring.SocialSphere.exception.ChatException;
import com.spring.SocialSphere.exception.MessageException;
import com.spring.SocialSphere.models.Message;
import com.spring.SocialSphere.models.User;

public interface MessageService {

	public Message createMessage(User user,Integer chatId,Message req) throws MessageException, ChatException;
	
	public List<Message> findChatsMessages(Integer chatId) throws MessageException, ChatException;
}
