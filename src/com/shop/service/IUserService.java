package com.shop.service;

import org.springframework.stereotype.Service;

import com.shop.entity.User;
import com.shop.exception.NameOrPasswordException;
import com.shop.exception.UserNotExistException;

public interface IUserService {
	//登陆的方法
	public void login(String username, String password) 
			throws UserNotExistException,NameOrPasswordException;
	
	//注册
	public void reg(User user);
	
	//修改用户信息
	public void modifyUser(int id ,User user);
	
	//修改密码
	public void modifyUserPassword(int id, String password);
	
}
