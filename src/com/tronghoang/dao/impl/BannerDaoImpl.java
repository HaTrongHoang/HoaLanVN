package com.tronghoang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tronghoang.dao.BannerDao;
import com.tronghoang.dao.JDBCConnection;
import com.tronghoang.model.Banner;

public class BannerDaoImpl extends JDBCConnection implements BannerDao {

	@Override
	public void updateBanner(Banner banner) {
		final String sql = "UPDATE banner SET image1=?,image2=?,image3=? WHERE id_banner=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, banner.getImage1());
			preparedStatement.setString(2, banner.getImage2());
			preparedStatement.setString(3, banner.getImage3());
			preparedStatement.setInt(4, banner.getId());
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Banner get(int id_banner) {
		final String sql = "SELECT * FROM banner WHERE id_banner=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_banner);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Banner banner = new Banner();
				banner.setId(rs.getInt("id_banner"));
				banner.setImage1(rs.getString("image1"));
				banner.setImage2(rs.getString("image2"));
				banner.setImage3(rs.getString("image3"));
				return banner;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
