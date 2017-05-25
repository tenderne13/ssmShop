package com.ssm.cart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.cart.po.Cart;
import com.ssm.cart.po.CartItem;
import com.ssm.category.po.Category;
import com.ssm.category.service.CategoryService;
import com.ssm.product.po.Product;
import com.ssm.product.po.ProductCustom;
import com.ssm.product.service.ProductService;
import com.ssm.utils.BasicAction;

@Controller
@RequestMapping(value="/cart")
public class CartAction extends BasicAction{
	
	@RequestMapping(value="addCart.do")
	public String addCart(ProductCustom productCustom,Model model,HttpSession httpSession,CartItem cartItem) throws Exception{
		
		System.out.println("cartItem信息为："+cartItem);
		//model.addAttribute("message",productCustom);
		int pid=productCustom.getPid();
		Product product=new Product();
		product.setPid(pid);
		List<Product> pro =productService.findProductByPid(product);
		product=pro.get(0);
		cartItem.setProduct(product);
		cartItem.setSubtotal(cartItem.getSubtotal());
//		model.addAttribute("message",cartItem);
		Cart cart=getCart(httpSession);
		cart.addCart(cartItem);
		System.out.println("添加进购物车的信息为："+cart.getTotal());
		httpSession.setAttribute("cart", cart);
		return "cart";
	}
	/*
	 * 从session中取刚才购买的shuju
	 */
	private Cart getCart(HttpSession httpSession){
		Cart cart=(Cart) httpSession.getAttribute("cart");
		if(cart==null){
			cart=new Cart();
			httpSession.setAttribute("cart", cart);
		}
		return cart;
	}
	@RequestMapping(value="/myCart.do")
	public String myCart(){
		return "cart";
	}
	
	@RequestMapping("/removeCart.do")
	public String removeCart(HttpSession httpSession,Product product){
		Cart cart=(Cart) httpSession.getAttribute("cart");
		int pid=product.getPid();
		cart.removeCart(pid);
		return "cart";
	}
	
	@RequestMapping("/clearCart.do")
	public String clearCart(HttpSession httpSession){
		Cart cart=(Cart) httpSession.getAttribute("cart");
		cart.clearCart();
		return "cart";
	}
}
