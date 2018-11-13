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
			//�����¼���ɹ�����Ҫ���ص�¼ҳ�棬������Ҫ���ص�¼ʧ����Ϣ
			request.setAttribute("msg", "�û������������");
			try {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
