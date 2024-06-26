package com.spring.SocialSphere.request;

import com.spring.SocialSphere.models.User;

public class CreateChatRequest {

	
	private Integer userId;
	
	public CreateChatRequest() {
		
	}

	public CreateChatRequest( Integer userId) {
		super();
		this.userId = userId;
	}

	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
