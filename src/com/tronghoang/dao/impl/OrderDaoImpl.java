package com.tronghoang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tronghoang.dao.JDBCConnection;
import com.tronghoang.dao.OrderDao;
import com.tronghoang.model.Order;
import com.tronghoang.model.User;

public class OrderDaoImpl extends JDBCConnection implements OrderDao {

	@Override
	public void addOrder(Order order) {
		final String sql = "INSERT INTO hoalanvn.order (idorder,customer,fullname,phone,address,total,date_created,mail) VALUE(?,?,?,?,?,?,?,?)";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, order.getIdorder());
			preparedStatement.setInt(2, order.getCustomer().getId_user());
			preparedStatement.setString(3, order.getFullname());
			preparedStatement.setString(4, order.getPhone());
			preparedStatement.setString(5, order.getAddress());
			preparedStatement.setFloat(6, order.getTotal());
			preparedStatement.setString(7, order.getDate_created());
			preparedStatement.setString(8, order.getMail());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("loi cu phap sql" + e);
		}
	}

	@Override
	public Order getId(String idorder) {
		final String sql = "SELECT * FROM hoalanvn.order INNER JOIN user ON user.id_user=hoalanvn.order.customer  WHERE idorder=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, idorder);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return rowMapper(rs);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private Order rowMapper(ResultSet rs) throws SQLException {
		Order order = new Order();
		order.setIdorder(rs.getString("idorder"));
		User user = new User();
		user.setId_user(rs.getInt("id_user"));
		order.setCustomer(user);
		order.setFullname(rs.getString("fullname"));
		order.setPhone(rs.getString("phone"));
		order.setAddress(rs.getString("address"));
		order.setDate_created(rs.getString("date_created"));
		order.setTotal(rs.getFloat("total"));
		order.setMail(rs.getString("mail"));
		return order;
	}
}
