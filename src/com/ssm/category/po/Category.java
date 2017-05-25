package com.ssm.category.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ssm.categorysecond.po.CategorySecond;

/**
 * 一级分类的实体类对象
 * @author 传智.郭嘉
 *
 */
public class Category implements Serializable{
	private Integer cid;
	private String cname;
	private Integer csid;
	// 一级分类中存放二级分类的集合:
	private List<CategorySecond> categorySeconds;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public List<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(List<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", csid=" + csid
				+ ", categorySeconds=" + categorySeconds + "]";
	}
	
	
}
