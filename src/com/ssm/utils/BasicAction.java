package com.ssm.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ssm.category.po.Category;
import com.ssm.category.service.CategoryService;
import com.ssm.order.service.orderService;
import com.ssm.product.service.ProductService;
import com.ssm.user.service.UserService;

public class BasicAction {
	@Autowired
	protected ProductService productService;	
	@Autowired
	protected CategoryService categoryService;
	@Autowired
	protected orderService orderService;
	@Autowired
	protected UserService userService;

	//公用数据
	@ModelAttribute(value="cList")
	public List<Category> getCategory() throws Exception{
		System.out.println("执行了一次");
		List<Category> list=categoryService.findAll();
		return list;
	}
	@ModelAttribute(value="csList")
	public List<Category> getCategorySecond()throws Exception{
		List<Category> list=categoryService.findOneAndSec();
		return list;
	}
	
}
