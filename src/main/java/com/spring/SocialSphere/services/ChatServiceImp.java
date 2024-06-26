package com.spring.SocialSphere.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SocialSphere.exception.ChatException;
import com.spring.SocialSphere.models.Chat;
import com.spring.SocialSphere.models.User;
import com.spring.SocialSphere.repository.ChatRepository;

@Service
public class ChatServiceImp implements ChatService {

	@Autowired
	private ChatRepository chatRepository;

	@Override
	public Chat createChat(User reqUser, User user2) {
		Chat isExist = chatRepository.findChatByUsersId(user2, reqUser);
		if(isExist != null) {
			return isExist;
		}
		Chat chat = new Chat();
		chat.getUsers().add(user2);
		chat.getUsers().add(reqUser);
		chat.setTimestamp(LocalDateTime.now());
		
		return chatRepository.save(chat);
	}
	
	@Override
	public Chat findChatById(Integer chatId) throws ChatException {
		Optional<Chat> opt = chatRepository.findById(chatId);
		if(opt.isEmpty()) {
			throw new ChatException("Chat not found with id : " + chatId);
		}
		return opt.get();
	}

	@Override
	public List<Chat> findAllChatByUserId(Integer userId) {
		
		return chatRepository.findByUsersId(userId);
	}


	
	 
}
