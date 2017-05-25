package com.ssm.product.po;

import java.io.Serializable;
import java.util.List;

public class ProductCustom extends Product implements Serializable{
	private Integer csid;
	private Integer cid;
	private Integer begin;
	private Integer limit;
	private List<Integer> ids;
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	@Override
	public String toString() {
		return "ProductCustom [csid=" + csid + ", cid=" + cid + ", begin="
				+ begin + ", limit=" + limit + ", ids=" + ids + ", getPid()="
				+ getPid() + ", getPname()=" + getPname()
				+ ", getMarket_price()=" + getMarket_price()
				+ ", getShop_price()=" + getShop_price() + ", getImage()="
				+ getImage() + ", getPdesc()=" + getPdesc() + ", getIs_hot()="
				+ getIs_hot() + ", getPdate()=" + getPdate() + "]";
	}
	
	
}
