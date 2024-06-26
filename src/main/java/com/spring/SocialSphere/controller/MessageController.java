package com.spring.SocialSphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.SocialSphere.models.Message;
import com.spring.SocialSphere.models.User;
import com.spring.SocialSphere.services.MessageService;
import com.spring.SocialSphere.services.UserService;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;
    
    @Autowired
    private UserService userService;

    @PostMapping("/api/messages/chat/{chatId}")
    public Message createMessage(@RequestBody Message req,
                                 @RequestHeader("Authorization") String jwt,
                                 @PathVariable Integer chatId) throws Exception {
        User user = userService.findUserByJwt(jwt);
        Message savedMessage = messageService.createMessage(user, chatId, req);
        return savedMessage;
    }
    
    @GetMapping("/api/messages/chat/{chatId}")
    public List<Message> findChatMessage(@RequestHeader("Authorization") String jwt,
                                 @PathVariable Integer chatId) throws Exception {
        User user = userService.findUserByJwt(jwt);
        List<Message> messages = messageService.findChatsMessages(chatId);
        return messages;
    }
}
