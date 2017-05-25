package com.ssm.user.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.category.po.Category;
import com.ssm.category.service.CategoryService;
import com.ssm.user.po.User;
import com.ssm.user.service.UserService;
import com.ssm.utils.BasicAction;

@Controller
@RequestMapping(value="/user")
public class UserAction extends BasicAction{
	
	//跳转到注册页面
	@RequestMapping(value="/registPage.do")
	public String registPage(){
		return "regist";
	}
	//登录跳转页面
	@RequestMapping(value="/loginPage.do")
	public String loginPage(){
		return "login";
	}
	//校验用户名是否被注册
	@RequestMapping(value="/validate.do")
	@ResponseBody
	public String validateUserName(User user) throws Exception{
		String username=user.getUsername();
		System.out.println("用户名为:"+username);
		List<User> list=userService.findUserName(user);
		if(list.size()>0){
			System.out.println("error");
			return "error";
		}else{
			System.out.println("success");
			return "success";
		}
	}
	
	//用户注册
	@RequestMapping(value="/regist.do")
	public String regist(User user,Model model)throws Exception{
		System.out.println("注册用户信息为:"+user);
		user.setState(1);
//		user.setCode("sss");
		userService.insertUser(user);
		model.addAttribute("message","用户注册成功");
		return "msg";
	}
	
	//用户登录
	@RequestMapping(value="/login.do")
	public String login(User user,Model model,HttpServletRequest req)throws Exception{
		System.out.println("登录用户信息为:"+user);
		HttpSession httpSession=req.getSession();
		System.out.println("session为："+httpSession.getAttributeNames());
		Cookie[] ck=req.getCookies();
		for(Cookie cookie:ck){
			System.out.println("cookie为:"+cookie.toString());
		}
		System.out.println("cookie为："+ck);
		User user1=userService.findUserByNP(user);
		if(user!=null){
			System.out.println("登录成功");
			httpSession.setAttribute("user", user1);
			return "forward:index.do";
		}else{
			System.out.println("用户名或者密码错误");
			model.addAttribute("message","用户名或者密码错误");
			return this.loginPage();
		}
	}
	
	//用户退出
	@RequestMapping(value="/quit.do")
	public String quit(HttpSession httpSession)throws Exception{
		httpSession.invalidate();
		return "forward:index.do";
	}
}
