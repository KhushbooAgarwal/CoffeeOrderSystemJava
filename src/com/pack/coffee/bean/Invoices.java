package com.pack.coffee.bean;

public class Invoices {
	
	private int invoiceId;
	private int orderId;
	private float netValue;
	private float gst;
	private float serviceTax;
	private float total;
	private float voucherAmt;
	private float price;


	public Invoices(){
	}


	

	public Invoices(int invoiceId, int orderId, float netValue, float gst, float serviceTax, float total,
			float voucherAmt, float price) {
		super();
		this.invoiceId = invoiceId;
		this.orderId = orderId;
		this.netValue = netValue;
		this.gst = gst;
		this.serviceTax = serviceTax;
		this.total = total;
		this.voucherAmt = voucherAmt;
		this.price = price;
	}




	public float getPrice() {
		return price;
	}




	public void setPrice(float price) {
		this.price = price;
	}




	public int getInvoiceId() {
		return invoiceId;
	}


	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public float getNetValue() {
		return netValue;
	}


	public void setNetValue(float netValue) {
		this.netValue = netValue;
	}


	public float getGst() {
		return gst;
	}


	public void setGst(float gst) {
		this.gst = gst;
	}


	public float getServiceTax() {
		return serviceTax;
	}


	public void setServiceTax(float serviceTax) {
		this.serviceTax = serviceTax;
	}


	public float getTotal() {
		return total;
	}


	public void setTotal(float total) {
		this.total = total;
	}


	public float getVoucherAmt() {
		return voucherAmt;
	}


	public void setVoucherAmt(float voucherAmt) {
		this.voucherAmt = voucherAmt;
	}
	

}
