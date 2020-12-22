package com.tronghoang.dao;

import java.util.List;

import com.tronghoang.model.User;

public interface UserDao {
	void addUser(User user);

	User getUser(String username);

	List<User> getAll(int limit, int offset);

	void deleteUser(int id_user);

	User getUserId(int id_user);

	void updateUser(User user);

	User searchUserName(String username);

	int totalUser();

	int totalSearch(String key);

	List<User> searchUser(String key, int limit, int offset);
}
