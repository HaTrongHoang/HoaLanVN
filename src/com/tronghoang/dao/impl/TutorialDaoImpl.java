package com.tronghoang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tronghoang.dao.JDBCConnection;
import com.tronghoang.dao.TutorialDao;
import com.tronghoang.model.Category;
import com.tronghoang.model.Tutorial;

public class TutorialDaoImpl extends JDBCConnection implements TutorialDao {

	@Override
	public void addTutorial(Tutorial tutorial) {
		final String sql = "INSERT INTO tutorial(title,thumbnail,describes,content,view,date_created,status,category_id,id_user) "
				+ "VALUE(?,?,?,?,?,?,?,?,?)";
		Category category = new Category();
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, tutorial.getTitle());
			preparedStatement.setString(2, tutorial.getThumbnail());
			preparedStatement.setString(3, tutorial.getDescribe());
			preparedStatement.setString(4, tutorial.getContent());
			preparedStatement.setInt(5, tutorial.getView());
			preparedStatement.setString(6, tutorial.getDate_created());
			preparedStatement.setString(7, tutorial.getStatus());
			preparedStatement.setInt(8, tutorial.getCategory_id().getId_category());
			preparedStatement.setString(9, tutorial.getId_user());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("loi cu phap sql" + e);
		}

	}

	@Override
	public List<Tutorial> getAll(int limit, int offset, int category_id) {
		List<Tutorial> tutorialList = new ArrayList<Tutorial>();
		final String sql = "SELECT * FROM tutorial INNER JOIN category ON category.id_category=tutorial.category_id WHERE category_id=? ORDER BY id_tutorial DESC LIMIT ? OFFSET ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, category_id);
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				tutorialList.add(rowMapper(rs));
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tutorialList;
	}

	private Tutorial rowMapper(ResultSet rs) throws SQLException {

		Tutorial tutorial = new Tutorial();
		tutorial.setId_tutorial(rs.getInt("id_tutorial"));
		Category category = new Category();
		category.setId_category(rs.getInt("category.id_category"));
		category.setName(rs.getString("category.name"));
		tutorial.setCategory_id(category);
		tutorial.setTitle(rs.getString("title"));
		tutorial.setThumbnail(rs.getString("thumbnail"));
		tutorial.setDescribe(rs.getString("describes"));
		tutorial.setContent(rs.getString("content"));
		tutorial.setView(rs.getInt("view"));
		tutorial.setDate_created(rs.getString("date_created"));
		tutorial.setStatus(rs.getString("status"));
		tutorial.setId_user(rs.getString("id_user"));
		return tutorial;
	}

	@Override
	public int totalTutorial(int category_id) {
		final String sql = "SELECT COUNT(*) AS total_tutorial FROM tutorial WHERE category_id=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, category_id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_tutorial");
				return total;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Tutorial getTutorialId(int id_tutorial) {
		final String sql = "SELECT * FROM tutorial INNER JOIN category ON category.id_category=tutorial.category_id WHERE id_tutorial=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_tutorial);
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
	public void updateTutorial(Tutorial tutorial) {
		final String sql = "UPDATE tutorial SET title=?,thumbnail=?,describes=?,content=?,category_id=? WHERE id_tutorial=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, tutorial.getTitle());
			preparedStatement.setString(2, tutorial.getThumbnail());
			preparedStatement.setString(3, tutorial.getDescribe());
			preparedStatement.setString(4, tutorial.getContent());
			preparedStatement.setInt(5, tutorial.getCategory_id().getId_category());
			preparedStatement.setInt(6, tutorial.getId_tutorial());
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteTutorial(int id_tutorial) {
		final String sql = "DELETE FROM tutorial WHERE id_tutorial = ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_tutorial);
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println("loi delete" + e);
		}

	}

	@Override
	public int totalSearch(String key) {
		final String sql = "SELECT COUNT(*) AS total_tutorial FROM tutorial WHERE title LIKE ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + key + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_tutorial");
				return total;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Tutorial> searchTutorial(String key, int limit, int offset) {
		List<Tutorial> listSearch = new ArrayList<Tutorial>();
		final String sql = "SELECT * FROM tutorial INNER JOIN category ON category.id_category=tutorial.category_id  WHERE title LIKE ? ORDER BY id_tutorial DESC LIMIT ? OFFSET ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + key + "%");
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
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
	public List<Tutorial> getAllHome(int limit, int offset) {
		List<Tutorial> tutorialList = new ArrayList<Tutorial>();
		final String sql = "SELECT * FROM tutorial INNER JOIN category ON category.id_category=tutorial.category_id ORDER BY id_tutorial DESC LIMIT ? OFFSET ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, limit);
			preparedStatement.setInt(2, offset);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				tutorialList.add(rowMapper(rs));
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tutorialList;
	}

	@Override
	public int totalTutorialAll() {
		final String sql = "SELECT COUNT(*) AS total_tutorial FROM tutorial ";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_tutorial");
				return total;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void updateViews(Tutorial tutorial) {
		final String sql = "UPDATE tutorial SET view=? WHERE id_tutorial=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, tutorial.getView());
			preparedStatement.setInt(2, tutorial.getId_tutorial());
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
