package com.ssm.user.mapper;

import java.util.List;

import com.ssm.user.po.User;

public interface UserMapper {
	public List<User> findUserName(User user)throws Exception;//根据姓名查询
	public void insertUser(User user)throws Exception;//插入用户
	public User findUserByNP(User user)throws Exception;
}
