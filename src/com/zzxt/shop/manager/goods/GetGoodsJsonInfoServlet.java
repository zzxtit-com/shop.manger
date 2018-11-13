package com.zzxt.shop.manager.goods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.zzxt.common.pojo.ResMessage;
import com.zzxt.shop.manager.order.OrderItem;

@WebServlet("/getGoodsJsonInfo.do")
public class GetGoodsJsonInfoServlet extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2682695693393080041L;

	private OrderService os = new OrderService();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String barCode = request.getParameter("barCode");
		try {
			ResMessage rm = new ResMessage();
			OrderItem oi = os.getOrderItemByBarcode(barCode);
			if(oi != null) {
				rm.setResCode(1);
				rm.setData(oi);
			}else {
				rm.setResCode(0);
				rm.setResMsg("此商品不存在！");
			}
			String resMsg = new Gson().toJson(rm);
			System.out.println("===================>" + resMsg);
			response.getWriter().write(resMsg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
