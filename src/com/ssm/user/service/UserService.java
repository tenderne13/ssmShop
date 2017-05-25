package com.ssm.user.service;

import java.util.List;

import com.ssm.user.po.User;

public interface UserService {
	public List<User> findUserName(User user)throws Exception;
	public void insertUser(User user)throws Exception;
	public User findUserByNP(User user)throws Exception;
}
