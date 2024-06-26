package com.spring.SocialSphere.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.SocialSphere.models.Message;

public interface MessageRepository extends JpaRepository<Message,Integer>{

	public List<Message> findByChatId(Integer ChatId);
}
