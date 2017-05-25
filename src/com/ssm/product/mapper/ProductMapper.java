package com.ssm.product.mapper;

import java.util.List;

import com.ssm.product.po.Product;
import com.ssm.product.po.ProductCustom;

public interface ProductMapper {
	public List<Product> findHot()throws Exception;
	public List<Product> findProductByPid(Product product) throws Exception;
	public List<Product> findNew()throws Exception;
	/*查询一级分类下的接口开始*/
	public int findCountByCid(ProductCustom productCustom)throws Exception;//查询一级分类下的二级分类的个数
	public List<ProductCustom> findByPageCid(ProductCustom productCustom)throws Exception;//根据cid查商品
	public List<Integer> findCsidByCid(ProductCustom productCustom)throws Exception;//查询一级分类下的二级分类id
	/*查询一级分类下的接口结束*/
	public List<ProductCustom> findByPageCsid(ProductCustom productCustom)throws Exception;//根据csid查商品
	public int findCountByCsid(ProductCustom productCustom)throws Exception;//查询二级分类下的商品个数
}
