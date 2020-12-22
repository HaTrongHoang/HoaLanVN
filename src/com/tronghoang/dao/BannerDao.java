package com.tronghoang.dao;

import com.tronghoang.model.Banner;

public interface BannerDao {
	void updateBanner(Banner banner);

	Banner get(int id_banner);

}
