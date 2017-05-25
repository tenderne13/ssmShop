package com.ssm.product.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.ssm.category.mapper.CategoryMapper;
import com.ssm.category.po.Category;
import com.ssm.order.mapper.OrderMapper;
import com.ssm.product.po.Product;
import com.ssm.product.po.ProductCustom;
import com.ssm.user.mapper.SelectiveMapper;
import com.ssm.user.mapper.UserMapper;
import com.ssm.user.po.Selective;
import com.ssm.user.po.User;

public class ProductMapperTest {
	private ApplicationContext applicationContext;
	private SqlSessionFactory sqlSessionFactory;
	private DataSourceTransactionManager transactionManager;
	private DefaultTransactionDefinition def;
	private TransactionStatus status;
	@Before
	public void setUp()throws Exception{
		applicationContext=new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
		sqlSessionFactory=(SqlSessionFactory) applicationContext.getBean("sqlSessionFactory");
		//new
		/*transactionManager = (DataSourceTransactionManager) applicationContext.getBean("transactionManager");
		//2.获取事务定义
		def = new DefaultTransactionDefinition();
		//3.设置事务隔离级别，开启新事务
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		//4.获得事务状态
		status = transactionManager.getTransaction(def);*/
		//创建回话工厂
		String resource="mybatis/SqlMapConfig.xml";
//		//加载配置文件到输入流
//		InputStream inputStream=Resources.getResourceAsStream(resource);
//		//绘画工厂
//		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public void testProductMapper() throws Exception {
		ProductMapper productMapper=(ProductMapper) applicationContext.getBean("productMapper");
		List<Product> list=productMapper.findHot();
		System.out.println(list);
	}
	public void testCategoryMapper()throws Exception{
		CategoryMapper categoryMapper=(CategoryMapper) applicationContext.getBean("categoryMapper");
		List<Category> list=categoryMapper.findAll();
		System.out.println("List:"+list);
	}
	
	public void testfindOneAndSec()throws Exception{
		CategoryMapper categoryMapper=(CategoryMapper) applicationContext.getBean("categoryMapper");
		List<Category> list=categoryMapper.findOneAndSec();
		System.out.println("List:"+list);
	}
	
	public void testfindProductByCsid() throws Exception{
		ProductMapper productMapper=(ProductMapper) applicationContext.getBean("productMapper");
		ProductCustom pro=new ProductCustom();
		pro.setCsid(1);
		pro.setBegin(0);
		pro.setLimit(8);
		List<ProductCustom> list =productMapper.findByPageCsid(pro);
		System.out.println("list内容为："+list);
	}
	
	public void testfindOrderByUid()throws Exception{
		OrderMapper orderMapper=(OrderMapper) applicationContext.getBean("orderMapper");
		User user=new User();
		user.setUid(7);
//		List<Order> list=orderMapper.findOrderByUid(user);
//		System.out.println("订单列表为："+list);
	}
	@Test
	public void testSeletive()throws Exception{
		SqlSession sqlSession1=sqlSessionFactory.openSession();
		SqlSession sqlSession2=sqlSessionFactory.openSession();
		UserMapper userMapper1=sqlSession1.getMapper(UserMapper.class);
		UserMapper UserMapper2=sqlSession2.getMapper(UserMapper.class);
		User user=new User();
		user.setUsername("lxp");
		
		List<User> user1=userMapper1.findUserName(user);
		System.out.println("用户名里"+user1);
//		transactionManager.commit(status);
//		status.flush();
		sqlSession1.close();
		
		
		List<User> user2=UserMapper2.findUserName(user);
		System.out.println(user2);
//		sqlSession2.commit();
		sqlSession2.close();
	}
}
