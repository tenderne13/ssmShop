package com.ssm.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * <p>Description：练手byte[]、Object互转<p>
 * 
 * @author Lxp
 *
 * 2016-10-2下午8:11:17
 */
public class RedisUtils {
	/**
	 * 对象转化为byte
	 * @param obj
	 * @return
	 */
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
	/**
	 * list对象转化为byte[]
	 * @param <T>
	 */
	public static <T> byte[] listTobyte(List<T> list){
		ByteArrayOutputStream os=new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(os);
			for(T t:list){
				oos.writeObject(t);
			}
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		byte[] b= os.toByteArray();
		return b;
	}
	
	/**
	 * byte转化为对象
	 * @param b
	 * @return
	 */
	public static Object ByteToObject(byte[] b){
		ByteArrayInputStream is=new ByteArrayInputStream(b);
		try {
			ObjectInputStream oi=new ObjectInputStream(is);
			is.close();
			oi.close();
			return oi.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * byte转化为List对象
	 * @param <T>
	 */
	public static <T> List<T> ByteToList(byte[] b){
		List<T> list=new ArrayList<T>();
		ByteArrayInputStream is=new ByteArrayInputStream(b);
		try {
			if(b!=null){
				ObjectInputStream oi=new ObjectInputStream(is);
				while(true){
					T t=(T) oi.readObject();
					if(t==null){
						break;
					}
					list.add(t);
				}
				is.close();
				oi.close();
				return list;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
