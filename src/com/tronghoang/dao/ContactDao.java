package com.tronghoang.dao;

import com.tronghoang.model.Contact;

public interface ContactDao {
	Contact getById(int id);

	void updateContact(Contact contact);
}
