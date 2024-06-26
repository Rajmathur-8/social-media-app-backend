package com.spring.SocialSphere.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SocialSphere.exception.PostException;
import com.spring.SocialSphere.exception.UserException;
import com.spring.SocialSphere.models.Post;
import com.spring.SocialSphere.models.User;
import com.spring.SocialSphere.repository.PostRepository;
import com.spring.SocialSphere.repository.UserRepository;

@Service
public class PostServiceImp implements PostService{

	@Autowired
	PostRepository postRepository;
	
	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Post createNewPost(Post post, Integer userId) throws PostException, UserException {
		
		User user = userService.findUserById(userId);
		Post newPost = new Post();
		newPost.setCaption(post.getCaption());
		newPost.setImage(post.getImage());
		newPost.setCreatedAt(LocalDateTime.now());
		newPost.setVideo(post.getVideo());
		newPost.setUser(user);
		
		return postRepository.save(newPost);
	}

	@Override
	public String deletePost(Integer postId, Integer userId) throws PostException, UserException {
		Post post = findPostById(postId);
		User user = userService.findUserById(userId); 
		if(post.getUser().getId() != user.getId()) {
			throw new PostException("You can't delete another users post");
		}
		postRepository.delete(post);
		return "Post deleted successfully with postId : "+postId;
		}

	@Override
	public List<Post> findPostByUserId(Integer userId) {
		
		return postRepository.findPostByUserId(userId);
	}

	@Override
	public Post findPostById(Integer postId) throws PostException {
		Optional<Post> opt = postRepository.findById(postId);
		if(opt.isEmpty()) {
			throw new PostException("Post not found with id : "+postId);
		}
		return opt.get();
	}

	@Override
	public List<Post> findAllPost() {
		return postRepository.findAll();
	}

	@Override
	public Post savedPost(Integer postId, Integer userId) throws PostException, UserException {
		Post post = findPostById(postId);
		User user = userService.findUserById(userId); 
		
		if(user.getSavedPost().contains(post)) {
			user.getSavedPost().remove(post);
		}
		else {
			user.getSavedPost().add(post);
		}
		return post;
	}

	@Override
	public Post likedPost(Integer postId, Integer userId) throws PostException, UserException {
		Post post = findPostById(postId);
		User user = userService.findUserById(userId); 
		
		if(post.getLiked().contains(user)) {
			post.getLiked().remove(user);
		}
		else {
		post.getLiked().add(user);
		}
		return postRepository.save(post);
	}

}
