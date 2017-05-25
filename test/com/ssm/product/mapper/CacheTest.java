package com.ssm.product.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.ssm.user.mapper.UserMapper;
import com.ssm.user.po.User;

public class CacheTest {
	//创建工厂
		private SqlSessionFactory sqlSessionFactory;
		@Before
		public void init() throws IOException{
			//创建回话工厂
			String resource="mybatis/SqlMapConfig.xml";
			//加载配置文件到输入流
			InputStream inputStream=Resources.getResourceAsStream(resource);
			//绘画工厂
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		}
	//一级缓存测试
		
	
	//二级缓存测试
	@Test
	public void testCache2() throws Exception {
		SqlSession sqlSession1=sqlSessionFactory.openSession();
//		SqlSession sqlSession2=sqlSessionFactory.openSession();
//		SqlSession sqlSession3=sqlSessionFactory.openSession();
		System.out.println("到这儿了");
		UserMapper userMapper1=sqlSession1.getMapper(UserMapper.class);
		System.out.println("到这儿了吗");
//		UserMapper userMapper2=sqlSession2.getMapper(UserMapper.class);
//		UserMapper userMapper3=sqlSession3.getMapper(UserMapper.class);
		User user=new User();
		user.setUsername("lxp");
		//第一次查询用户
		List<User> user1=userMapper1.findUserName(user);
		System.out.println(user1);
		sqlSession1.commit();
		sqlSession1.close();
		//中间修改数据需要清空缓存，防止产生脏数据
//		User user3=new User();
//		user3.setUsername("贾欣琪");
//		user3.setSex("女");
//		user3.setAddress("保定");
//		userMapper1.insertUser(user3);
//		sqlSession.commit();
//		//第二次查询用户
//		User user2=userMapper2.findUserById(10);
//		System.out.println(user2);
//		sqlSession2.commit();
//		sqlSession2.close();
//		User user3=userMapper3.findUserById(10);
//		sqlSession3.commit();
//		sqlSession3.close();
	}
		

}
