package com.spring.SocialSphere.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SocialSphere.exception.ReelsException;
import com.spring.SocialSphere.exception.UserException;
import com.spring.SocialSphere.models.Reels;
import com.spring.SocialSphere.models.User;
import com.spring.SocialSphere.repository.ReelsRepository;

@Service
public class ReelsServiceImp implements ReelsService {
	@Autowired
	private ReelsRepository reelsRepository;
	@Autowired
	private UserService userService;

	@Override
	public Reels createReel(Reels reel, User user) {
		Reels createReel = new Reels();
		createReel.setTitle(reel.getTitle());
		createReel.setUser(user);
		createReel.setVideo(reel.getVideo());
		
		return reelsRepository.save(createReel);
	}

	@Override
	public List<Reels> findAllReels() {
		
		return reelsRepository.findAll();
	}

	@Override
	public List<Reels> findUserReel(Integer userId) throws ReelsException, UserException {
		userService.findUserById(userId);
		return reelsRepository.findByUserId(userId);
	}

}
