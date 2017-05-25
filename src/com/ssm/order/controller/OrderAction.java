package com.ssm.order.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.category.po.Category;
import com.ssm.category.service.CategoryService;
import com.ssm.order.po.Order;
import com.ssm.order.service.orderService;
import com.ssm.user.po.User;
import com.ssm.user.po.UserCustom;
import com.ssm.utils.BasicAction;
import com.ssm.utils.PageBean;

@Controller
@RequestMapping("/order")
public class OrderAction extends BasicAction{
	
	@RequestMapping("/findByUid.do")
	public String findByUid(UserCustom userCustom, Model model,Integer page,HttpSession httpSession) throws Exception{
		System.out.println("user信息为：");
//		List<Order> list=orderService.findOrderByUid(user);
		List<User> list=(List<User>) httpSession.getAttribute("userList");
		System.out.println("list大小："+list);
		if(list!=null){
			User user=list.get(0);
			userCustom.setUid(user.getUid());
			PageBean<Order> pageBean=orderService.findOrderByUid(userCustom, page);
			model.addAttribute("pageBean",pageBean);
			System.out.println("pageBean:"+pageBean.getList());
//			model.addAttribute("message", list);
			return "orderList";
		}else{
			model.addAttribute("message","登录已过期，请重新登录");
			return "msg";
		}
			
		
			
		
		
	}
}
