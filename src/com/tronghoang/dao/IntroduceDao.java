package com.tronghoang.dao;

import com.tronghoang.model.Introduce;

public interface IntroduceDao {
	Introduce get(int id);

	void update(Introduce introduce);
}
