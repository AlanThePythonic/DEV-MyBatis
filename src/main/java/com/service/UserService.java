package com.service;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

import com.bean.User;
import com.mapper.UserMapper;
import com.util.MyBatisUtil;

public class UserService {

	public void insertUser(User user) {

		try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.insertUser(user);
			sqlSession.commit();
		}
	}

	public User getUserById(Integer userId) {

		try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			return userMapper.getUserById(userId);
		}
	}

	public List<User> getAllUsers() {

		try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			return userMapper.getAllUsers();
		}
	}

	public void updateUser(User user) {

		try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.updateUser(user);
			sqlSession.commit();
		}
	}

	public void deleteUser(Integer userId) {

		try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.deleteUser(userId);
			sqlSession.commit();
		}
	}
}