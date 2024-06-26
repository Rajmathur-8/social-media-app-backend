package com.spring.SocialSphere.services;

import com.spring.SocialSphere.exception.CommentException;
import com.spring.SocialSphere.exception.PostException;
import com.spring.SocialSphere.exception.UserException;
import com.spring.SocialSphere.models.Comment;

public interface CommentService {

	public Comment createComment(Comment comment,Integer postId,Integer userId) throws CommentException, UserException, PostException;
	
	public Comment likeComment(Integer commentId,Integer userId) throws CommentException, UserException;
	
	public Comment findCommentById(Integer commentId) throws CommentException;
}
