package com.tronghoang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tronghoang.dao.JDBCConnection;
import com.tronghoang.dao.UserDao;
import com.tronghoang.model.User;

public class UserDaoImpl extends JDBCConnection implements UserDao {

	@Override
	public void addUser(User user) {
		final String sql = "INSERT INTO  user(fullname,username,password,datebirth,address,gender,role,image,date_created,status,phone)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, user.getFullname());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getDatebirth());
			preparedStatement.setString(5, user.getAddress());
			preparedStatement.setString(6, user.getGender());
			preparedStatement.setInt(7, user.getRole());
			preparedStatement.setString(8, user.getImage());
			preparedStatement.setString(9, user.getDate_created());
			preparedStatement.setString(10, user.getStatus());
			preparedStatement.setString(11, user.getPhone());
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public User getUser(String username) {
		final String sql = "SELECT * FROM user WHERE username=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, username);
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

	@Override
	public List<User> getAll(int limit, int offset) {
		List<User> userList = new ArrayList<User>();
		final String sql = "SELECT * FROM user LIMIT ? OFFSET ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, limit);
			preparedStatement.setInt(2, offset);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				userList.add(rowMapper(rs));
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList;
	}

	@Override
	public void deleteUser(int id_user) {
		final String sql = "DELETE FROM user WHERE id_user = ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_user);
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println("loi delete" + e);
		}

	}

	private User rowMapper(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId_user(rs.getInt("id_user"));
		user.setFullname(rs.getString("fullname"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setDatebirth(rs.getString("datebirth"));
		user.setAddress(rs.getString("address"));
		user.setGender(rs.getString("gender"));
		user.setPhone(rs.getString("phone"));
		user.setRole(rs.getInt("role"));
		user.setImage(rs.getString("image"));
		user.setDate_created(rs.getString("date_created"));
		user.setStatus(rs.getString("status"));
		return user;
	}

	@Override
	public User getUserId(int id_user) {
		final String sql = "SELECT * FROM user WHERE id_user=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_user);
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

	@Override
	public void updateUser(User user) {
		final String sql = "UPDATE user SET fullname=?,datebirth=?,address=?,gender=?,phone=?,role=?,image=? WHERE id_user=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, user.getFullname());
			preparedStatement.setString(2, user.getDatebirth());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setString(4, user.getGender());
			preparedStatement.setString(5, user.getPhone());
			preparedStatement.setInt(6, user.getRole());
			preparedStatement.setString(7, user.getImage());
			preparedStatement.setInt(8, user.getId_user());
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public User searchUserName(String username) {
		String sql = "SELECT * FROM user WHERE username=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, username);
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

	@Override
	public int totalUser() {
		final String sql = "SELECT COUNT(*) AS total_user FROM user";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_user");
				return total;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<User> searchUser(String key, int limit, int offset) {
		List<User> listSearch = new ArrayList<User>();
		final String sql = "SELECT * FROM user  WHERE fullname LIKE ? OR username LIKE ? LIMIT ? OFFSET ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + key + "%");
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
	public int totalSearch(String key) {
		final String sql = "SELECT COUNT(*) AS total FROM user  WHERE fullname LIKE ? OR username LIKE ? ";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + key + "%");
			preparedStatement.setString(2, "%" + key + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total");
				return total;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
