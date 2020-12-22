package com.tronghoang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tronghoang.dao.JDBCConnection;
import com.tronghoang.dao.NewsDao;
import com.tronghoang.model.News;

public class NewsDaoImpl extends JDBCConnection implements NewsDao {

	@Override
	public void addNews(News news) {
		final String sql = "INSERT INTO news(title,thumbnail,describes,content,view,date_created,status,id_user) "
				+ "VALUE(?,?,?,?,?,?,?,?)";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, news.getTitle());
			preparedStatement.setString(2, news.getThumbnail());
			preparedStatement.setString(3, news.getDescribe());
			preparedStatement.setString(4, news.getContent());
			preparedStatement.setInt(5, news.getView());
			preparedStatement.setString(6, news.getDate_created());
			preparedStatement.setString(7, news.getStatus());
			preparedStatement.setString(8, news.getId_user());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("loi cu phap sql" + e);
		}

	}

	@Override
	public List<News> getAll(int limit, int offset) {
		List<News> newsList = new ArrayList<News>();
		final String sql = "SELECT * FROM news ORDER BY id_news DESC LIMIT ? OFFSET ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, limit);
			preparedStatement.setInt(2, offset);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				newsList.add(rowMapper(rs));
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return newsList;
	}

	private News rowMapper(ResultSet rs) throws SQLException {
		News news = new News();
		news.setId_news(rs.getInt("id_news"));
		news.setTitle(rs.getString("title"));
		news.setThumbnail(rs.getString("thumbnail"));
		news.setDescribe(rs.getString("describes"));
		news.setContent(rs.getString("content"));
		news.setView(rs.getInt("view"));
		news.setDate_created(rs.getString("date_created"));
		news.setStatus(rs.getString("status"));
		news.setId_user(rs.getString("id_user"));
		return news;
	}

	@Override
	public int totalNews() {
		final String sql = "SELECT COUNT(*) AS total_news FROM news";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_news");
				return total;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public News getNewsId(int id_news) {
		final String sql = "SELECT * FROM news WHERE id_news=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_news);
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
	public void updateNews(News news) {
		final String sql = "UPDATE news SET title=?,thumbnail=?,describes=?,content=? WHERE id_news=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, news.getTitle());
			preparedStatement.setString(2, news.getThumbnail());
			preparedStatement.setString(3, news.getDescribe());
			preparedStatement.setString(4, news.getContent());
			preparedStatement.setInt(5, news.getId_news());
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteNews(int id_news) {
		final String sql = "DELETE FROM news WHERE id_news = ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_news);
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println("loi delete" + e);
		}
	}

	@Override
	public int totalSearch(String key) {
		final String sql = "SELECT COUNT(*) AS total_news FROM news WHERE title LIKE ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + key + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_news");
				return total;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<News> searchNews(String key, int limit, int offset) {
		List<News> listSearch = new ArrayList<News>();
		final String sql = "SELECT * FROM news  WHERE title LIKE ? ORDER BY id_news DESC LIMIT ? OFFSET ?";
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
	public void updateViews(News news) {
		final String sql = "UPDATE news SET view=? WHERE id_news=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, news.getView());
			preparedStatement.setInt(2, news.getId_news());
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
