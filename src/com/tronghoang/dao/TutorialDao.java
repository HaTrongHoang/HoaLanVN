package com.tronghoang.dao;

import java.util.List;

import com.tronghoang.model.Tutorial;

public interface TutorialDao {
	void addTutorial(Tutorial tutorial);

	List<Tutorial> getAll(int limit, int offset, int category_id);

	int totalTutorial(int category_id);

	Tutorial getTutorialId(int id_tutorial);

	void updateTutorial(Tutorial tutorial);

	void deleteTutorial(int id_tutorial);

	int totalSearch(String key);

	List<Tutorial> searchTutorial(String key, int limit, int offset);

	List<Tutorial> getAllHome(int limit, int offset);

	int totalTutorialAll();

	void updateViews(Tutorial tutorial);

}
