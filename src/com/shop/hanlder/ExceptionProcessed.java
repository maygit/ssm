package com.shop.hanlder;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.shop.exception.NameOrPasswordException;
import com.shop.exception.UserNotExistException;

@ControllerAdvice
public class ExceptionProcessed {
	@ExceptionHandler({NameOrPasswordException.class,UserNotExistException.class})
	public ModelAndView userException(Exception ex){
		ModelAndView mv  = new ModelAndView("login");
		mv.addObject("exception", ex.getMessage());
		return mv;
	}
}
