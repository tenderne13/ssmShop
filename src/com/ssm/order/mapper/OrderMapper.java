package com.ssm.order.mapper;

import java.util.List;

import com.ssm.order.po.Order;
import com.ssm.user.po.User;
import com.ssm.user.po.UserCustom;

public interface OrderMapper {
	public List<Order> findOrderByUid(UserCustom userCustom)throws Exception;
	
	public int selectTotalCount(UserCustom userCustom)throws Exception;
}
