package com.shop.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.shop.dao.UserMapper;
import com.shop.entity.User;

public class TestMapper {
	public static void main(String[] args) {
		SqlSessionFactoryBuilder builder =
				new SqlSessionFactoryBuilder();
		InputStream is = TestMapper.class.getResourceAsStream("/mybatis.cfg.xml");
		SqlSessionFactory factory = builder.build(is);
		
		//3.锟斤拷取锟结话
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> user = mapper.queryAll();
		for (User user2 : user) {
			System.out.println(user2);
		}
	}

}
