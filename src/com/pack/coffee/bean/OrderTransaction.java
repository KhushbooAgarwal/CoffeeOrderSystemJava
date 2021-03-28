package com.pack.coffee.bean;

public class OrderTransaction {
	
	private int orderTranId;
	private int orderId;
	private int coffeeId;
	private int addOnID;

	public OrderTransaction(){
	}

	public OrderTransaction(int orderTranId, int orderId, int coffeeId, int addOnID) {
		super();
		this.orderTranId = orderTranId;
		this.orderId = orderId;
		this.coffeeId = coffeeId;
		this.addOnID = addOnID;
	}

	public int getOrderTranId() {
		return orderTranId;
	}

	public void setOrderTranId(int orderTranId) {
		this.orderTranId = orderTranId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCoffeeId() {
		return coffeeId;
	}

	public void setCoffeeId(int coffeeId) {
		this.coffeeId = coffeeId;
	}

	public int getAddOnID() {
		return addOnID;
	}

	public void setAddOnID(int addOnID) {
		this.addOnID = addOnID;
	}

	

}
