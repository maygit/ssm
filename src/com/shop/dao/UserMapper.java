package com.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.shop.entity.User;
public interface UserMapper {
	
	@Insert("insert into t_user(userid,name,password,age) values(#{id},#{name},#{password},#{age})")
	public int save(User user);
	
	@Delete("delete from t_user where userid = #{id}")
	public int deleteById(int id);

	@Update("update t_user set name=#{name},password=#{password},age=#{age} where userid=#{id}")
	public int update(User user);
	
	@Select("select userid id ,name,password,age from t_user")
	public List<User> queryAll();
	
	@Select("select userid id,name,password,age from t_user where userid=#{id}")
	public User queryById(int id);

	@Select("select userid id,name,password,age from t_user where name=#{name}")
	public User queryByName(String name);
}
