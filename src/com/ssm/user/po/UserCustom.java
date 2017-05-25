package com.ssm.user.po;

import java.io.Serializable;

public class UserCustom extends User implements Serializable{
	private Integer begin;
	private Integer limit;
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
	@Override
	public String toString() {
		return "UserCustom [begin=" + begin + ", limit=" + limit
				+ ", getUid()=" + getUid() + ", getUsername()=" + getUsername()
				+ "]";
	}
	
}
