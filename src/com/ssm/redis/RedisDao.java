package com.ssm.redis;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.ssm.user.po.User;
import com.ssm.utils.RedisUtils;

public class RedisDao {
	private static  JedisPool jedisPool;
	public RedisDao(String ip,int port){
		jedisPool=new JedisPool(ip,port);
	}
	
//	private RuntimeSchema<User> schema=RuntimeSchema.createForm(User.class);
	/**
	 * 得到单个实体
	 * @param uid
	 * @return
	 */
	public User getUser(String username){
		Jedis jedis=null;
		try {
			jedis=jedisPool.getResource();
			String key="user:"+username;
			byte[] bytes= jedis.get(key.getBytes());
			if(bytes!=null){
				User user=(User) RedisUtils.ByteToObject(bytes);
				return user;
			}
		} catch (Exception e) {
		}finally{
			returnResource(jedis);
		}
		return null;
	}
	
	/**
	 * 放入单个User实体
	 * @param user
	 * @return
	 */
	public String putUser(User user){
		//set Object ->byte[] 序列化
		String result;
		Jedis jedis=null;
		try {
			jedis=jedisPool.getResource();
			String key="user:"+user.getUsername();
			byte[] bu=RedisUtils.ObjectToByte(user);
			result = jedis.set(key.getBytes(), bu);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			returnResource(jedis);
		}
		return null;
	}
	
	/**
	 * 放入UserList
	 * @param list
	 * @return
	 */
	public String putListUser(List<User> list){
		String result;
		Jedis jedis=null;
		try {
			jedis=jedisPool.getResource();
			String key="userList";
			byte[] bu=RedisUtils.ObjectToByte(list);
			result = jedis.set(key.getBytes(), bu);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/** 
     * 释放jedis资源 
     * @param jedis 
     */  
    public static void returnResource(final Jedis jedis) {  
        if (jedis != null && jedisPool !=null) {  
            jedisPool.returnResource(jedis);  
        }  
    }  
}