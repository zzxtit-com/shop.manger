package com.zzxt.shop.manager.goods;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzxt.shop.manager.order.OrderItem;

@WebServlet("/showGoods.do")
public class ShowGoodsServlet extends HttpServlet{

	private OrderService os = new OrderService();
	 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	
	/**
	 * 空间复杂度
	 * 运算复杂度
	 * 
	 * 
	 * 使用LinkedList 存储商品信息
	 * 使用map存储  barcode 和 数量
	 * 
	 * 
	 * 
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("=============================>");
		String barCode = req.getParameter("barCode");
		String goodsCount = req.getParameter("goodsCount");
		Integer gc = 0;
		
		if(goodsCount != null && !"".equals(goodsCount)) {
			gc = Integer.parseInt(goodsCount);
		}else {
			gc = 1;
		}
		
		
		List<OrderItem> orList = null;
		Object o = req.getSession().getAttribute("orderItemList");
		if(o != null) {
			orList = (List<OrderItem>) o;
		}else {
			orList = new LinkedList<OrderItem>();
		}
		
		boolean isNotExist = true;
		
		for(OrderItem oi : orList) {
			if(oi.getBarCode().equals(barCode)) {
				oi.setGoodsCount(oi.getGoodsCount() + gc);
				isNotExist = false;
				break;
			}
		}
		
		if(isNotExist) {
			try {
				OrderItem oi = os.getOrderItemByBarcode(barCode);
				oi.setGoodsCount(gc);
				orList.add(oi);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		req.getSession().setAttribute("orderItemList", orList);
		resp.sendRedirect("jsp/goods/showGoods.jsp");
	}
	
}
