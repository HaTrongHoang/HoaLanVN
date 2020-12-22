package com.tronghoang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tronghoang.dao.IntroduceDao;
import com.tronghoang.dao.JDBCConnection;
import com.tronghoang.model.Introduce;

public class IntroduceDaoImpl extends JDBCConnection implements IntroduceDao {

	@Override
	public Introduce get(int id) {
		final String sql = "SELECT * FROM introduction WHERE id=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Introduce introduce = new Introduce();
				introduce.setId(rs.getInt("id"));
				introduce.setContent(rs.getString("content"));
				return introduce;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Introduce introduce) {
		final String sql = "UPDATE introduction SET content=? WHERE id=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, introduce.getContent());
			preparedStatement.setInt(2, introduce.getId());
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
