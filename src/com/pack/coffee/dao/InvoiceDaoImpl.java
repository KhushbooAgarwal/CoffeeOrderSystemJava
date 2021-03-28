package com.pack.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pack.coffee.bean.Invoices;
import com.pack.coffee.util.MySQLConnectionManagement;

public class InvoiceDaoImpl implements InvoiceDao {

	@Override
	public int CreateInvoice(int invoiceNum,int orderId, float netValue, float gst, float serviceTax, float total,float price,
			float voucherAmt) throws ClassNotFoundException, SQLException {
		
		Connection connection = null;
		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("INSERT INTO INVOICES VALUES(?,?,?,?,?,?,?,?)");
	
		statement.setInt(1, invoiceNum);
		statement.setInt(2, orderId);
		statement.setFloat(3, netValue);
		statement.setFloat(4, gst);
		statement.setFloat(5, serviceTax);
		statement.setFloat(6, total);
		statement.setFloat(7, price);
		statement.setFloat(8, voucherAmt);
		
		
		int rows = statement.executeUpdate();
	
		connection.close();
		return rows;
	
	}

	@Override
	public Invoices getInvoiceByOrderId(int orderId) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Invoices invoice = null;
		
		connection = MySQLConnectionManagement.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM INVOICES WHERE ORDER_ID=?");
		statement.setInt(1, orderId);
	

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			invoice = new Invoices();
			invoice.setInvoiceId(resultSet.getInt(1));
			invoice.setOrderId(resultSet.getInt(2));
			invoice.setNetValue(resultSet.getFloat(3));
			invoice.setGst(resultSet.getFloat(4));
			invoice.setServiceTax(resultSet.getFloat(5));
			invoice.setTotal(resultSet.getFloat(6));
			invoice.setPrice(resultSet.getFloat(7));
			invoice.setVoucherAmt(resultSet.getFloat(8));
			
		}
		connection.close(); // throwing check exception SQLException

		return invoice;
	
	}
	
	
	@Override
	public int getMaxInvoiceId() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		int id= 0;
		
		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT MAX(INVOICE_NO) FROM INVOICES");
	
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {		
			id = resultSet.getInt(1);
			
			//System.out.println(id);
			
		}
		connection.close(); // throwing check exception SQLException

		return id;
	}

}
