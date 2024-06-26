package com.spring.SocialSphere.services;

import java.util.List;

import com.spring.SocialSphere.exception.ReelsException;
import com.spring.SocialSphere.exception.UserException;
import com.spring.SocialSphere.models.Reels;
import com.spring.SocialSphere.models.User;

public interface ReelsService {
	
	public Reels createReel(Reels reel,User user);
	
	public List<Reels> findAllReels();
	
	public List<Reels> findUserReel(Integer userId) throws ReelsException, UserException;
	

}
