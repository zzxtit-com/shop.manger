package com.zzxt.shop.manager.goods;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.zzxt.common.util.DbUtil;

public class GoodsDao {

	private QueryRunner qr = new QueryRunner(DbUtil.getDataSource());
	
	public Goods getGoodsByBarCode(String barCode) throws SQLException {
		String sql = "select id, bar_code barCode, goods_name goodsName, price, type  from goods where bar_code ='" + barCode + "'" ;
		System.out.println("sql-------------->" + sql);
		return qr.query(sql, new BeanHandler<Goods>(Goods.class));
	}
}
