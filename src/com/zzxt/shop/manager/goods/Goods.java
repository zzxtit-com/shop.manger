package com.zzxt.shop.manager.goods;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {

	private String goodsName;
	
	private String barCode;
	
	private Date productDate;
	
	private String producer;
	
	private Date expriDate;
	
	//
	private BigDecimal price;
	
	private int type;

	/**
	 * @return the goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}

	/**
	 * @param goodsName the goodsName to set
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	/**
	 * @return the barCode
	 */
	public String getBarCode() {
		return barCode;
	}

	/**
	 * @param barCode the barCode to set
	 */
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	/**
	 * @return the productDate
	 */
	public Date getProductDate() {
		return productDate;
	}

	/**
	 * @param productDate the productDate to set
	 */
	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	/**
	 * @return the producer
	 */
	public String getProducer() {
		return producer;
	}

	/**
	 * @param producer the producer to set
	 */
	public void setProducer(String producer) {
		this.producer = producer;
	}

	/**
	 * @return the expriDate
	 */
	public Date getExpriDate() {
		return expriDate;
	}

	/**
	 * @param expriDate the expriDate to set
	 */
	public void setExpriDate(Date expriDate) {
		this.expriDate = expriDate;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
}
