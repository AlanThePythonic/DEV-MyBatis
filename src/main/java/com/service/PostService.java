package com.service;

import org.apache.ibatis.session.SqlSession;
import com.bean.Post;
import com.mapper.PostMapper;
import com.util.MyBatisUtil;

public class PostService {

	public Post getAllPostByPostId(int postId) {

		try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
			PostMapper postMapper = sqlSession.getMapper(PostMapper.class);
			return postMapper.getAllPostByPostId(postId);
		}
	}

	public void insertPost(Post post) {

		try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
			PostMapper postMapper = sqlSession.getMapper(PostMapper.class);
			postMapper.insertPost(post);
			sqlSession.commit();
		}
	}
}
