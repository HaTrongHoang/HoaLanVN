package com.tronghoang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tronghoang.dao.JDBCConnection;
import com.tronghoang.dao.ProductDao;
import com.tronghoang.model.Product;
import com.tronghoang.model.User;

public class ProductDaoImpl extends JDBCConnection implements ProductDao {

	@Override
	public void add(Product product) {
		String sql = "INSERT INTO product(name, price, image, category, des,user,date_created,status,amount) VALUES (?,?,?,?,?,?,?,?,?)";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setFloat(2, product.getPrice());
			ps.setString(3, product.getImage());
			ps.setString(4, product.getCategory());
			ps.setString(5, product.getDes());
			ps.setInt(6, product.getUser().getId_user());
			ps.setString(7, product.getDate_created());
			ps.setString(8, product.getStatus());
			ps.setInt(9, product.getAmount());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> getAllId(int limit, int offset, int id_user) {
		List<Product> productList = new ArrayList<Product>();
		final String sql = "SELECT * FROM product INNER JOIN user ON user.id_user=product.user WHERE user=? ORDER BY id DESC LIMIT ? OFFSET ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_user);
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				productList.add(rowMapper(rs));
			}
			conn.close();

		} catch (SQLException e) {
			System.out.println("sai" + e);
			e.printStackTrace();
		}
		return productList;
	}

	private Product rowMapper(ResultSet rs) throws SQLException {
		Product product = new Product();
		product.setId(rs.getInt("id"));
		product.setName(rs.getString("name"));
		product.setPrice(rs.getFloat("price"));
		product.setImage(rs.getString("image"));
		product.setDes(rs.getString("des"));
		product.setCategory(rs.getString("category"));
		User user = new User();
		user.setId_user(rs.getInt("id_user"));
		user.setFullname(rs.getString("fullname"));
		user.setPhone(rs.getString("phone"));
		user.setAddress(rs.getString("address"));
		product.setUser(user);
		product.setDate_created(rs.getString("date_created"));
		product.setStatus(rs.getString("status"));
		product.setAmount(rs.getInt("amount"));
		return product;

	}

	@Override
	public int totalProductId(int id_user) {
		final String sql = "SELECT COUNT(*) AS total_product FROM product INNER JOIN user ON user.id_user=product.user WHERE user=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_user);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_product");
				return total;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Product> getAll(String status, int limit, int offset) {
		List<Product> productList = new ArrayList<Product>();
		final String sql = "SELECT * FROM product INNER JOIN user ON user.id_user=product.user WHERE product.status=? ORDER BY id DESC LIMIT ? OFFSET ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, status);
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				productList.add(rowMapper(rs));
			}
			conn.close();

		} catch (SQLException e) {
			System.out.println("sai" + e);
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public int totalProductAll(String status) {
		final String sql = "SELECT COUNT(*) AS total_product FROM product INNER JOIN user ON user.id_user=product.user WHERE product.status=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, status);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_product");
				return total;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Product getId(int id) {
		final String sql = "SELECT * FROM product INNER JOIN user ON user.id_user=product.user WHERE id=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return rowMapper(rs);
			}
			conn.close();

		} catch (SQLException e) {
			System.out.println("sai" + e);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Product product) {
		final String sql = "UPDATE product SET name=?,price=?,category=?,des=?,image=?,amount=?,user=?,date_created=?,status=? WHERE id=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setFloat(2, product.getPrice());
			preparedStatement.setString(3, product.getCategory());
			preparedStatement.setString(4, product.getDes());
			preparedStatement.setString(5, product.getImage());
			preparedStatement.setInt(6, product.getAmount());
			preparedStatement.setInt(7, product.getUser().getId_user());
			preparedStatement.setString(8, product.getDate_created());
			preparedStatement.setString(9, product.getStatus());
			preparedStatement.setInt(10, product.getId());
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		final String sql = "DELETE FROM product WHERE id = ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println("loi delete" + e);
		}

	}

	@Override
	public void updateStatus(String status, int id) {
		final String sql = "UPDATE product SET status=? WHERE id=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, status);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Product> getSearch(String key, String status, int limit, int offset) {
		List<Product> listSearch = new ArrayList<Product>();
		final String sql = "SELECT * FROM product INNER JOIN user ON user.id_user=product.user WHERE product.status=? AND product.name LIKE ? ORDER BY id DESC LIMIT ? OFFSET ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, status);
			preparedStatement.setString(2, "%" + key + "%");
			preparedStatement.setInt(3, limit);
			preparedStatement.setInt(4, offset);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				listSearch.add(rowMapper(rs));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listSearch;
	}

	@Override
	public int totalSearch(String key, String status) {
		final String sql = "SELECT COUNT(*) AS total_product FROM product INNER JOIN user ON user.id_user=product.user  WHERE product.status=? AND product.name LIKE ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, status);
			preparedStatement.setString(2, "%" + key + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_product");
				return total;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
