package com.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.Reader;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.shop.dao.UserMapper;
import com.shop.entity.User;
import com.shop.exception.NameOrPasswordException;
import com.shop.exception.UserExistException;
import com.shop.exception.UserNotExistException;
import com.shop.service.IUserService;
@Service("UserServiceImpl")
public class UserServiceImpl implements IUserService {
	
	@Override
	public void login(String username, String password) 
			throws UserNotExistException,NameOrPasswordException{
        SqlMapClient sqlMapclient = null;
        try {
            Reader reader = com.ibatis.common.resources.Resources
                    .getResourceAsReader("SqlMapConfig.xml");
            sqlMapclient = com.ibatis.sqlmap.client.SqlMapClientBuilder
                    .buildSqlMapClient(reader);
            reader.close();
            List<User> users = (List<User>) sqlMapclient.queryForList("selectUser", username);
           System.out.println(users);
            if(users == null){
                throw new UserNotExistException("用户不存在");
            }
            if(users == null){
                throw new UserNotExistException("用户不存在");
            }
            //3.判断密码是否相等
            for(User u:users){
                if(!password.equals(u.getPassword())){
                    throw new NameOrPasswordException("用户名或密码错误！");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Transactional
	@Override
	public void reg(User user) {

	}

	@Override
	public void modifyUser(int id, User user) {

	}

	@Override
	public void modifyUserPassword(int id, String password) {

	}

}
