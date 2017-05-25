package com.ssm.category.mapper;

import java.util.List;

import com.ssm.category.po.Category;

public interface CategoryMapper {
	public List<Category> findAll()throws Exception;
	public List<Category> findOneAndSec()throws Exception;
}
