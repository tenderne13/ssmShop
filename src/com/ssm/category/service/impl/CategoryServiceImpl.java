package com.ssm.category.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ssm.category.mapper.CategoryMapper;
import com.ssm.category.po.Category;
import com.ssm.category.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public List<Category> findAll() throws Exception {
		return categoryMapper.findAll();
	}
	
	
	@Override
	public List<Category> findOneAndSec() throws Exception {
		return categoryMapper.findOneAndSec();
	}
	
}
