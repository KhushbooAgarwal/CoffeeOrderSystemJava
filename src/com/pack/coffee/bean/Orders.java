package com.pack.coffee.bean;

import java.util.Date;

public class Orders {

	private int orderId;
	private int customerId;
	private Date orderDate;
	private int voucherID;

	public Orders(){
	}

	public Orders(int customerId, Date orderDate, int voucherID) {
		super();
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.voucherID = voucherID;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getVoucherID() {
		return voucherID;
	}

	public void setVoucherID(int voucherID) {
		this.voucherID = voucherID;
	}
	
	
	
}
