package com.shop.hanlder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.entity.User;
import com.shop.exception.NameOrPasswordException;
import com.shop.exception.UserExistException;
import com.shop.exception.UserNotExistException;
import com.shop.service.IUserService;
@RequestMapping("/user")
@Controller
public class UserHandler {
	@Autowired
	@Qualifier("UserServiceImpl")
	private IUserService service;
	/**
	 * REST风格
	 * @param name
	 * @param password
	 * @throws NameOrPasswordException  login
	 * @throws UserNotExistException   login
	 */
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("name") String name,
			@RequestParam("password")String password)
	throws NameOrPasswordException,UserNotExistException{
		service.login(name, password);
		return "success";
	}
	
	@RequestMapping(value="/reg",method=RequestMethod.POST)
	public String reg(User user)
	throws UserExistException{
		service.reg(user);
		return "success";
	}
}
