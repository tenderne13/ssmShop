package com.ssm.product.mapper;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;

import com.ssm.user.po.User;

public class TestRedis {
	public static void main(String[] args) {
		Jedis jedis=new Jedis("localhost", 6379);
		List<Integer> list=new ArrayList<Integer>();
//		list.add(1);
//		list.add(89);
//		list.add(934);
		Long result=null;
		for(Integer i:list){
			result=jedis.lpush("intkey", i.toString());
		}
//		jedis.del("intkey");
		System.out.println(jedis.lrange("intkey", 0, -1));
		List<String> slist=jedis.lrange("intkey", 0, -1);
		for(String s:slist){
			list.add(Integer.parseInt(s));
		}
		System.out.println(list);
	}
	
}
