package com.ssm.order.service;

import java.util.List;

import com.ssm.order.po.Order;
import com.ssm.user.po.User;
import com.ssm.user.po.UserCustom;
import com.ssm.utils.PageBean;

public interface orderService {
	public PageBean<Order> findOrderByUid(UserCustom userCustom,Integer page)throws Exception;
}
