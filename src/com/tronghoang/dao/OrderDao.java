package com.tronghoang.dao;

import com.tronghoang.model.Order;

public interface OrderDao {
	void addOrder(Order order);

	Order getId(String idorder);
}
