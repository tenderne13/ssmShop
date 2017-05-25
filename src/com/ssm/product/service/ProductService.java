package com.ssm.product.service;

import java.util.List;

import com.ssm.product.po.Product;
import com.ssm.product.po.ProductCustom;
import com.ssm.utils.PageBean;

public interface ProductService {
	public List<Product> findHot()throws Exception;
	public List<Product> findProductByPid(Product product) throws Exception;
	public List<Product> findNew()throws Exception;
	public PageBean<ProductCustom> findByPageCid(ProductCustom productCustom,int page)throws Exception;
	public PageBean<ProductCustom> findByPageCsid(ProductCustom productCustom,int page)throws Exception;
}
