package com.ssm.categorysecond.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ssm.category.po.Category;
import com.ssm.product.po.Product;


/**
 * 二级分类的实体
 * @author 传智.郭嘉
 *
 */
public class CategorySecond implements Serializable{
	private Integer csid;
	private String csname;
	private Integer parid;
	// 所属一级分类.存的是一级分类的对象.
	// 配置商品集合
	private List<Product> products;
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Integer getParid() {
		return parid;
	}
	public void setParid(Integer parid) {
		this.parid = parid;
	}
	@Override
	public String toString() {
		return "CategorySecond [csid=" + csid + ", csname=" + csname
				+ ", parid=" + parid + ", products=" + products + "]";
	}
	
	
	
}
