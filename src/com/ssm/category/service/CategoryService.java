package com.ssm.category.service;

import java.util.List;

import com.ssm.category.po.Category;

public interface CategoryService {
	public List<Category> findAll()throws Exception;
	public List<Category> findOneAndSec()throws Exception;
}
