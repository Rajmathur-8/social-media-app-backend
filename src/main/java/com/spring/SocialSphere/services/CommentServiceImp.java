package com.spring.SocialSphere.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SocialSphere.exception.CommentException;
import com.spring.SocialSphere.exception.PostException;
import com.spring.SocialSphere.exception.UserException;
import com.spring.SocialSphere.models.Comment;
import com.spring.SocialSphere.models.Post;
import com.spring.SocialSphere.models.User;
import com.spring.SocialSphere.repository.CommentRepository;
import com.spring.SocialSphere.repository.PostRepository;

@Service
public class CommentServiceImp implements CommentService{
	
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private PostService postService;
	@Autowired
	private UserService userService;
	@Autowired
	private PostRepository postRepository;

	@Override
	public Comment createComment(Comment comment, Integer postId, Integer userId) throws CommentException, UserException, PostException {
		User user = userService.findUserById(userId);
		Post post = postService.findPostById(postId);
		
		comment.setUser(user);
		comment.setContent(comment.getContent());
		comment.setCreatedAt(LocalDateTime.now());
		
		Comment savedComment = commentRepository.save(comment);
		
		post.getComments().add(savedComment);
		postRepository.save(post);
		
		return savedComment;
	}

	@Override
	public Comment likeComment(Integer commentId, Integer userId) throws CommentException, UserException {
		Comment comment = findCommentById(commentId);
		User user = userService.findUserById(userId);
		if(!comment.getLiked().contains(user)) {
			comment.getLiked().add(user);
		}else comment.getLiked().remove(user);
		return commentRepository.save(comment);
	}

	@Override
	public Comment findCommentById(Integer commentId) throws CommentException {
		
		Optional<Comment> opt = commentRepository.findById(commentId);
		if(opt.isEmpty()) {
			throw new CommentException("Comment not Exist");
		}
		
		return opt.get();
	}
	
	

}
