package com.tronghoang.dao;

import java.util.List;

import com.tronghoang.model.Product;

public interface ProductDao {
	void add(Product product);

	List<Product> getAllId(int limit, int offset, int id_user);

	int totalProductId(int id_user);

	List<Product> getAll(String status, int limit, int offset);

	int totalProductAll(String status);

	Product getId(int id);

	void update(Product product);

	void delete(int id);

	void updateStatus(String status, int id);

	List<Product> getSearch(String key, String status, int limit, int offset);

	int totalSearch(String key, String status);
}
