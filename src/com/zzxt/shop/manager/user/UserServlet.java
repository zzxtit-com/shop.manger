package com.zzxt.shop.manager.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzxt.common.util.FormUtil;
import com.zzxt.common.web.util.BaseServlet;

@WebServlet("/userManager")
public class UserServlet extends BaseServlet{

	private UserDao userDao = new UserDao();
	
	public void addUser(HttpServletRequest request, HttpServletResponse response){
		User user = (User) FormUtil.fromToBean(request, User.class);
		
		
		userDao.addUser(user);
		
		
	}
	
}
