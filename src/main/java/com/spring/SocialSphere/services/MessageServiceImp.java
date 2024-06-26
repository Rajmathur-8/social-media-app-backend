package com.spring.SocialSphere.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SocialSphere.exception.ChatException;
import com.spring.SocialSphere.exception.MessageException;
import com.spring.SocialSphere.models.Chat;
import com.spring.SocialSphere.models.Message;
import com.spring.SocialSphere.models.User;
import com.spring.SocialSphere.repository.ChatRepository;
import com.spring.SocialSphere.repository.MessageRepository;

@Service
public class MessageServiceImp implements MessageService{

	@Autowired
	private MessageRepository messageRepository; 
	@Autowired
	private ChatService chatService;
	@Autowired
	private ChatRepository chatRepository;
	
	@Override
	public Message createMessage(User user, Integer chatId, Message req) throws MessageException, ChatException {
		Chat chat = chatService.findChatById(chatId);
		Message message = new Message();
		message.setChat(chat);
		message.setContent(req.getContent());
		message.setImage(req.getImage());
		message.setUser(user);
		message.setTimeStamp(LocalDateTime.now());
		Message savedMessages = messageRepository.save(message);
		
		chat.getMessages().add(savedMessages);
		chatRepository.save(chat);
		return savedMessages;
	}

	@Override
	public List<Message> findChatsMessages(Integer chatId) throws MessageException, ChatException {
		Chat chat = chatService.findChatById(chatId);
		return messageRepository.findByChatId(chatId);
	}

}
