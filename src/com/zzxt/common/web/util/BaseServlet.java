package com.zzxt.common.web.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * �s����s����
 * 
 * @author zzxt
 *
 */
public class BaseServlet extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8781769905824998497L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String methodName = request.getParameter("mn");
		System.out.println("�͑��H�󷽷�:" + methodName);
		try {
			//
			Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
			
		} catch (NoSuchMethodException e) {
			throw new RuntimeException("�]��Ո��ķ���������");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
