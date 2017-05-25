package com.ssm.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.category.po.Category;
import com.ssm.category.service.CategoryService;
import com.ssm.categorysecond.po.CategorySecond;
import com.ssm.product.po.Product;
import com.ssm.product.po.ProductCustom;
import com.ssm.product.service.ProductService;
import com.ssm.utils.BasicAction;
import com.ssm.utils.PageBean;

@Controller
@RequestMapping(value="/user")
public class ProductAction extends BasicAction{
	
	//根据商品id查询详细信息
	@RequestMapping(value="/findProductByPid.do")
	public String findProductById(Product product,Model model) throws Exception{
		List<Product> list=productService.findProductByPid(product);
		System.out.println("商品详情为："+list);
		model.addAttribute("product", list);
		return "product";
	}
	//根据cid查询商品
	@RequestMapping(value="/findByCid.do")
	public ModelAndView findByCid(ProductCustom productCustom,Model model,Integer page)throws Exception{
		System.out.println("productCustom信息为："+productCustom);
		System.out.println("页数为："+page);
		PageBean<ProductCustom> pag=productService.findByPageCid(productCustom, page);
		System.out.println("pag内容为："+pag);
		model.addAttribute("message",pag);
		model.addAttribute("pageBean",pag);
		return new ModelAndView("productList");
	}
	//根据csid查询
	@RequestMapping(value="/findByCsid.do")
	public String findByCsid(ProductCustom productCustom,Model model,Integer page)throws Exception{
		System.out.println("productCustom信息为"+productCustom);
		PageBean<ProductCustom> pag=productService.findByPageCsid(productCustom, page);
		System.out.println("pag内容为："+pag);
//		model.addAttribute("message",pag);
		model.addAttribute("pageBean",pag);
		return "productList";
	}
}
