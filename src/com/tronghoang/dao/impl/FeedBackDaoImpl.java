package com.tronghoang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tronghoang.dao.FeedBackDao;
import com.tronghoang.dao.JDBCConnection;
import com.tronghoang.model.FeedBack;

public class FeedBackDaoImpl extends JDBCConnection implements FeedBackDao {

	@Override
	public List<FeedBack> getWait(int status, int limit, int offset) {
		List<FeedBack> feedbackListWait = new ArrayList<FeedBack>();
		final String sql = "SELECT * FROM feedback WHERE status=? ORDER BY id_feedback DESC LIMIT ? OFFSET ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, status);
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				feedbackListWait.add(rowMapper(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return feedbackListWait;
	}

	private FeedBack rowMapper(ResultSet rs) throws SQLException {
		FeedBack feedback = new FeedBack();
		feedback.setId_feedback(rs.getInt("id_feedback"));
		feedback.setFullname(rs.getString("fullname"));
		feedback.setMail(rs.getString("mail"));
		feedback.setTitle(rs.getString("title"));
		feedback.setContent(rs.getString("content"));
		feedback.setStatus(rs.getInt("status"));
		feedback.setId_user(rs.getString("id_user"));
		feedback.setCreated(rs.getString("created"));
		return feedback;
	}

	@Override
	public int totalFeedBackWait() {
		final String sql = "SELECT COUNT(*) AS total_feedbackWait FROM feedback";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_feedbackWait");
				return total;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void addFeedBack(FeedBack feedback) {
		final String sql = "INSERT INTO feedback(fullname,mail,title,content,status,created) VALUE(?,?,?,?,?,?)";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, feedback.getFullname());
			preparedStatement.setString(2, feedback.getMail());
			preparedStatement.setString(3, feedback.getTitle());
			preparedStatement.setString(4, feedback.getContent());
			preparedStatement.setInt(5, feedback.getStatus());
			preparedStatement.setString(6, feedback.getCreated());
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateFeedBack(FeedBack feedback) {
		final String sql = "UPDATE feedback SET status=?, id_user=? WHERE id_feedback=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, feedback.getStatus());
			preparedStatement.setString(2, feedback.getId_user());
			preparedStatement.setInt(3, feedback.getId_feedback());
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteFeedBack(int id_feedback) {
		final String sql = "DELETE FROM feedback WHERE id_feedback=? ";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_feedback);
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int totalSearch(String key) {
		final String sql = "SELECT COUNT(*) AS total_feedback FROM feedback WHERE fullname LIKE ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + key + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_feedback");
				return total;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<FeedBack> searchFeedBack(String key, int limit, int offset) {
		List<FeedBack> listSearch = new ArrayList<FeedBack>();
		final String sql = "SELECT * FROM feedback  WHERE fullname LIKE ? ORDER BY id_feedback DESC LIMIT ? OFFSET ?";
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
	public FeedBack getFeedBackId(int id_feedback) {
		final String sql = "SELECT * FROM feedback  WHERE id_feedback=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_feedback);
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

}
