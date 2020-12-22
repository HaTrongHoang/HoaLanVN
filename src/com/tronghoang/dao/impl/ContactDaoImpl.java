package com.tronghoang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tronghoang.dao.ContactDao;
import com.tronghoang.dao.JDBCConnection;
import com.tronghoang.model.Contact;

public class ContactDaoImpl extends JDBCConnection implements ContactDao {

	@Override
	public Contact getById(int id) {
		final String sql = "SELECT * FROM contact WHERE id=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");
				Contact contact = new Contact();
				contact.setPhone(phone);
				contact.setEmail(email);
				contact.setAddress(address);
				return contact;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateContact(Contact contact) {
		final String sql = "UPDATE contact SET phone=?,email=?,address=? WHERE id=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, contact.getPhone());
			preparedStatement.setString(2, contact.getEmail());
			preparedStatement.setString(3, contact.getAddress());
			preparedStatement.setInt(4, contact.getId());
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
