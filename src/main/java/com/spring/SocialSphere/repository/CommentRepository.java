package com.spring.SocialSphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.SocialSphere.models.Comment;

public interface CommentRepository extends JpaRepository<Comment,Integer>{

}
