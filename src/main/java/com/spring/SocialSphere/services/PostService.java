package com.spring.SocialSphere.services;

import java.util.List;

import com.spring.SocialSphere.exception.PostException;
import com.spring.SocialSphere.exception.UserException;
import com.spring.SocialSphere.models.Post;

public interface PostService {

	public Post createNewPost(Post post,Integer userId)throws PostException, UserException;

	public String deletePost(Integer postId,Integer userId) throws PostException, UserException;
	
	public List<Post> findPostByUserId(Integer userId);
	
	public Post findPostById(Integer postId) throws PostException;
	
	public List<Post> findAllPost();
	
	public Post savedPost(Integer postId,Integer userId) throws PostException, UserException;
	
	public Post likedPost(Integer postId,Integer userId) throws PostException, UserException;
}
