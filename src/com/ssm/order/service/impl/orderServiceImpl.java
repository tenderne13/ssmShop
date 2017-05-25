package com.ssm.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.order.mapper.OrderMapper;
import com.ssm.order.po.Order;
import com.ssm.order.service.orderService;
import com.ssm.product.po.Product;
import com.ssm.product.po.ProductCustom;
import com.ssm.product.service.ProductService;
import com.ssm.user.po.User;
import com.ssm.user.po.UserCustom;
import com.ssm.utils.PageBean;
@Service
public class orderServiceImpl implements  orderService{
	@Autowired
	private OrderMapper orderMapper;
	@Override
	public PageBean<Order> findOrderByUid(UserCustom userCustom,Integer page) throws Exception {
		PageBean<Order> pageBean=new PageBean<Order>();
		pageBean.setPage(page);
		int limit=5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount=orderMapper.selectTotalCount(userCustom);
		pageBean.setTotalCount(totalCount);
		// 设置总页数:
		int totalPage = 0;
		// Math.ceil(totalCount / limit);
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合:
		// 从哪开始:
		int begin = (page - 1) * limit;
		userCustom.setBegin(begin);
		userCustom.setLimit(limit);
		List<Order> list=orderMapper.findOrderByUid(userCustom);
		pageBean.setList(list);
		return pageBean;
	}


}
