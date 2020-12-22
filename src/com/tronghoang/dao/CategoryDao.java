package com.tronghoang.dao;

import java.util.List;

import com.tronghoang.model.Category;

public interface CategoryDao {
	List<Category> getAll(int limit, int offset);

	int totalCategory();

	List<Category> getCategory();

	void addCategory(Category category);

	Category getCategoryName(String name);

	void deleteCategory(int id_category);

	Category getCategoryById(int id_category);

	void updateCategory(Category category);

	int totalSearch(String key);

	List<Category> searchCategory(String key, int limit, int offset);

}
