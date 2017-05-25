package com.ssm.product.mapper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.ssm.redis.RedisDao;
import com.ssm.user.po.User;
import com.ssm.utils.RedisUtils;


/**
 * 
 * 对象转为byte字符测试
 * 
 * @author Lxp
 *
 * 2016-9-13
 */
public class Test {
	public static byte[] ObjectToByte(Object obj){
		ByteArrayOutputStream os=new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(os);
			oos.writeObject(obj);
			
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		byte[] b= os.toByteArray();
		return b;
	}
	public static Object ByteToObject(byte[] b){
		ByteArrayInputStream is=new ByteArrayInputStream(b);
		try {
			ObjectInputStream oi=new ObjectInputStream(is);
			return oi.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) throws IOException {
		List<User> list=new ArrayList<User>();
		User user =new User();
		User user1=new User();
//		RedisDao redisDao=new RedisDao("192.168.214.128", 6379);
		user.setUid(19);
		user.setName("李小朋");
		user1.setUid(20);
		user.setUsername("贾欣琪");
		list.add(user);
		list.add(user1);
		byte[] b= RedisUtils.listTobyte(list);
		System.out.println(b);
		List<User> list1=RedisUtils.ByteToList(b);
		System.out.println(list1);
//		String result=redisDao.putUser(user);
//		System.out.println("result:"+result);
//		User user2=redisDao.getUser(19);
//		System.out.println(user2);
	}
}
