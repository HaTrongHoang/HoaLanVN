package com.tronghoang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tronghoang.dao.JDBCConnection;
import com.tronghoang.dao.OrderDetailDao;
import com.tronghoang.model.DetailOrder;
import com.tronghoang.model.Order;
import com.tronghoang.model.Product;
import com.tronghoang.model.User;

public class OrderDetailDaoImpl extends JDBCConnection implements OrderDetailDao {

	@Override
	public void addOrderDetail(DetailOrder orderDetail) {
		final String sql = "INSERT INTO hoalanvn.detailorder(id_order,product,amount,total_product,status) "
				+ "VALUE(?,?,?,?,?)";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, orderDetail.getIdorder().getIdorder());
			preparedStatement.setInt(2, orderDetail.getProduct().getId());
			preparedStatement.setInt(3, orderDetail.getAmount());
			preparedStatement.setFloat(4, orderDetail.getTotal_product());
			preparedStatement.setInt(5, orderDetail.getStatus());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("loi cu phap sql detailorder" + e);
		}

	}

	@Override
	public List<DetailOrder> getStatus(int status, int limit, int offset) {
		List<DetailOrder> listGetStatus = new ArrayList<DetailOrder>();
		final String sql = "SELECT * FROM detailorder INNER JOIN product ON product.id=detailorder.product INNER JOIN user ON product.user=user.id_user INNER JOIN hoalanvn.order ON hoalanvn.order.idorder=detailorder.id_order WHERE detailorder.status = ?  ORDER BY iddetailorder DESC LIMIT ? OFFSET ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, status);
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				listGetStatus.add(rowMapper(rs));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listGetStatus;
	}

	private DetailOrder rowMapper(ResultSet rs) throws SQLException {
		DetailOrder detailOrder = new DetailOrder();
		detailOrder.setIddetailorder(rs.getInt("iddetailorder"));
		Order order = new Order();
		order.setIdorder(rs.getString("idorder"));
		order.setAddress(rs.getString("address"));
		order.setFullname(rs.getString("fullname"));
		order.setPhone(rs.getString("phone"));
		order.setTotal(rs.getFloat("total"));
		order.setDate_created(rs.getString("date_created"));
		User userMua = new User();
		userMua.setId_user(rs.getInt("id_user"));
		order.setCustomer(userMua);
		detailOrder.setIdorder(order);
		Product product = new Product();
		product.setId(rs.getInt("id"));
		product.setName(rs.getString("name"));
		product.setPrice(rs.getFloat("price"));
		product.setDes(rs.getString("des"));
		User userBan = new User();
		userBan.setFullname(rs.getString("fullname"));
		userBan.setPhone(rs.getString("phone"));
		userBan.setAddress(rs.getString("address"));
		userBan.setId_user(rs.getInt("id_user"));
		product.setUser(userBan);
		detailOrder.setProduct(product);
		detailOrder.setAmount(rs.getInt("amount"));
		detailOrder.setTotal_product(rs.getFloat("total_product"));
		detailOrder.setStatus(rs.getInt("status"));
		return detailOrder;
	}

	@Override
	public int totalStatus(int status) {
		final String sql = "SELECT COUNT(*) AS total_status FROM detailorder INNER JOIN product ON product.id=detailorder.product INNER JOIN user ON hoalanvn.product.user=user.id_user INNER JOIN hoalanvn.order ON hoalanvn.order.idorder=detailorder.id_order WHERE detailorder.status = ?  ";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, status);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_status");
				return total;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<DetailOrder> Search(String key, int limit, int offset, int status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStatus(int id, int status) {
		final String sql = "UPDATE detailorder SET status=? WHERE iddetailorder=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, status);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<DetailOrder> getAllOrder(int id_user, int limit, int offset) {
		List<DetailOrder> listGetOrder = new ArrayList<DetailOrder>();
		final String sql = "SELECT * FROM detailorder INNER JOIN product ON product.id=detailorder.product INNER JOIN user ON product.user=user.id_user INNER JOIN hoalanvn.order ON hoalanvn.order.idorder=detailorder.id_order WHERE customer = ?  ORDER BY iddetailorder DESC LIMIT ? OFFSET ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_user);
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				listGetOrder.add(rowMapper(rs));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listGetOrder;
	}

	@Override
	public int totalAllOrder(int id_user) {
		final String sql = "SELECT COUNT(*) AS total_allorder FROM detailorder INNER JOIN product ON product.id=detailorder.product INNER JOIN user ON hoalanvn.product.user=user.id_user INNER JOIN hoalanvn.order ON hoalanvn.order.idorder=detailorder.id_order WHERE customer = ?  ";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_user);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_allorder");
				return total;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<DetailOrder> getIdOrder(String idorder) {
		List<DetailOrder> listDetailOrder = new ArrayList<DetailOrder>();

		final String sql = "SELECT * FROM detailorder INNER JOIN product ON product.id=detailorder.product INNER JOIN user ON product.user=user.id_user INNER JOIN hoalanvn.order ON hoalanvn.order.idorder=detailorder.id_order WHERE order.idorder=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, idorder);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				listDetailOrder.add(rowMapper(rs));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listDetailOrder;
	}

	@Override
	public DetailOrder getId(int id) {
		final String sql = "SELECT * FROM detailorder INNER JOIN product ON product.id=detailorder.product INNER JOIN user ON product.user=user.id_user INNER JOIN hoalanvn.order ON hoalanvn.order.idorder=detailorder.id_order WHERE iddetailorder=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return rowMapper(rs);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
