package com.ssm.index;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.category.po.Category;
import com.ssm.category.service.CategoryService;
import com.ssm.product.po.Product;
import com.ssm.product.service.ProductService;
import com.ssm.utils.BasicAction;

@Controller
@RequestMapping(value="/user")
public class Index extends BasicAction{
	
	@RequestMapping(value="index.do")
	public String index(Model model,HttpSession httpSession)throws Exception{
		List<Product> hList=productService.findHot();
//		List<Category>cList=categoryService.findAll();
		List<Product>nList=productService.findNew();
//		List<Category>csList=categoryService.findOneAndSec();
		System.out.println("hList"+hList);
//		System.out.println("cList:"+cList);
		model.addAttribute("hList",hList);
		model.addAttribute("nList",nList);
		/*
		 * 用@ModelAttribute将一二级分类放到公共数据上。不再存放在session中。
		 */
//		httpSession.setAttribute("cList", cList);
//		httpSession.setAttribute("csList", csList);
		return "index";
	}
}
