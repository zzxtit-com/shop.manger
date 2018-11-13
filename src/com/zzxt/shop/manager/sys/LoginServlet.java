package com.zzxt.shop.manager.sys;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userName = request.getParameter("userName");
		String passwd = request.getParameter("passwd");
		if("root".equals(userName)) {
			request.getSession().setAttribute("userInfo", userName);
			response.sendRedirect(request.getContextPath()+"/jsp/common/main.jsp");
		}else {
			//如果登录不成功，需要返回登录页面，而且需要返回登录失败信息
			request.setAttribute("msg", "用户名或密码错误！");
			try {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
