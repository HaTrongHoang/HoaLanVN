package com.tronghoang.dao;

import java.util.List;

import com.tronghoang.model.DetailOrder;

public interface OrderDetailDao {
	void addOrderDetail(DetailOrder orderDetail);

	List<DetailOrder> getStatus(int status, int limit, int offset);

	int totalStatus(int status);

	void updateStatus(int id, int status);

	List<DetailOrder> Search(String key, int limit, int offset, int status);

	List<DetailOrder> getAllOrder(int id_user, int limit, int offset);

	int totalAllOrder(int id_user);

	List<DetailOrder> getIdOrder(String idorder);

	DetailOrder getId(int id);

}
