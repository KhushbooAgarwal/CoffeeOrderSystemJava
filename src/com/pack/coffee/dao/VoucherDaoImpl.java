package com.pack.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pack.coffee.bean.Orders;
import com.pack.coffee.bean.Vouchers;
import com.pack.coffee.util.MySQLConnectionManagement;

public class VoucherDaoImpl implements VoucherDao {

	@Override
	public ArrayList<Vouchers> getAllVouchers() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vouchers getVoucherByVoucherName(String voucherName) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Vouchers vouchers = null;
		
		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM VOUCHERS WHERE VOUCHER_NAME=?");
		statement.setString(1, voucherName);
	

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			vouchers = new Vouchers();
			vouchers.setVoucherID(resultSet.getInt(1));
			vouchers.setVoucherName(resultSet.getString(2));
			vouchers.setVoucherPrice(resultSet.getInt(3));
		
			
		}
		connection.close(); // throwing check exception SQLException

		return vouchers;
	}

}
