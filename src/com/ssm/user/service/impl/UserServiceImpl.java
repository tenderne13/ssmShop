package com.ssm.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.util.RedisInputStream;

import com.googlecode.ehcache.annotations.Cacheable;
import com.ssm.redis.RedisDao;
import com.ssm.user.mapper.UserMapper;
import com.ssm.user.po.User;
import com.ssm.user.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RedisDao redisDao;
	@Override
	public List<User> findUserName(User user) throws Exception {
		return userMapper.findUserName(user);
	}
	@Override
	public void insertUser(User user) throws Exception {
		userMapper.insertUser(user);
	}
	@Override
	@Cacheable(cacheName="menuCache")
	public User findUserByNP(User user) throws Exception {
		User user1=null;
		String username=user.getUsername();
		user1=redisDao.getUser(username);
		if(user1==null){
			user1=userMapper.findUserByNP(user);
			String result=redisDao.putUser(user1);
			System.out.println("插入redis缓存结果:"+result);
		}
		return user1;
	}

}
