package com.ssm.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.product.mapper.ProductMapper;
import com.ssm.product.po.Product;
import com.ssm.product.po.ProductCustom;
import com.ssm.product.service.ProductService;
import com.ssm.utils.PageBean;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	@Override
	public List<Product> findHot() throws Exception {
		return productMapper.findHot();
	}
	@Override
	public List<Product> findProductByPid(Product product) throws Exception {
		return productMapper.findProductByPid(product);
	}
	@Override
	public List<Product> findNew() throws Exception {
		return productMapper.findNew();
	}
	@Override
	public PageBean<ProductCustom> findByPageCid(ProductCustom productCustom,
			int page) throws Exception {
		PageBean<ProductCustom> pageBean = new PageBean<ProductCustom>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 8;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		List<Integer> ids=productMapper.findCsidByCid(productCustom);//选出一级分类下的二级id组合
		productCustom.setIds(ids);
		totalCount=productMapper.findCountByCid(productCustom);//选出一级分类下的商品数量
//		totalCount=productMapper.findByPageCid(productCustom);
		// 设置总页数:
		int totalPage = 0;
		// Math.ceil(totalCount / limit);
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合:
		// 从哪开始:
		int begin = (page - 1) * limit;
		productCustom.setBegin(begin);
		productCustom.setLimit(limit);
		int cid= productCustom.getCid();
		List<ProductCustom> list=productMapper.findByPageCid(productCustom);
		for(ProductCustom custom:list){
			custom.setCsid(null);
		}
		pageBean.setCid(cid);
		pageBean.setList(list);
		return pageBean;
	}
	@Override
	public PageBean<ProductCustom> findByPageCsid(ProductCustom productCustom,
			int page) throws Exception {
		PageBean<ProductCustom> pageBean = new PageBean<ProductCustom>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 8;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount=productMapper.findCountByCsid(productCustom);
		int totalPage = 0;
		// Math.ceil(totalCount / limit);
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合:
		// 从哪开始:
		int begin = (page - 1) * limit;
		productCustom.setBegin(begin);
		productCustom.setLimit(limit);
		int csid=productCustom.getCsid();
		List<ProductCustom> list=productMapper.findByPageCsid(productCustom);
		pageBean.setCsid(csid);
		pageBean.setCid(0);
		pageBean.setList(list);
		return pageBean;
	}

}
