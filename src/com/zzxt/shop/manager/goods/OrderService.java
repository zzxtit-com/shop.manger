package com.zzxt.shop.manager.goods;

import org.apache.commons.beanutils.BeanUtils;

import com.zzxt.shop.manager.order.OrderItem;

public class OrderService {

	private GoodsDao gd = new GoodsDao();
	
	
	public OrderItem getOrderItemByBarcode(String barCode) throws Exception {
		OrderItem oi = null;
		Goods goods = gd.getGoodsByBarCode(barCode);
		if(goods != null) {
			oi = new OrderItem();
			BeanUtils.copyProperties(oi, goods);
		}
		
		return oi;
	}
	
}
