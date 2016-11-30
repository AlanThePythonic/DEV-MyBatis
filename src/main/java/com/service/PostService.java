package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Post;
import com.mapper.PostMapper;

@Service
@Transactional
public class PostService implements BaseService{

	@Autowired
	private PostMapper postService;

	public Post getAllPostByPostId(int postId) {
		return postService.getAllPostByPostId(postId);
	}

	public void insertPost(Post post) {
		postService.insertPost(post);
	}
}
