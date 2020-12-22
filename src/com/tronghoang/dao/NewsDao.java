package com.tronghoang.dao;

import java.util.List;

import com.tronghoang.model.News;

public interface NewsDao {
	void addNews(News news);

	List<News> getAll(int limit, int offset);

	int totalNews();

	News getNewsId(int id_news);

	void updateNews(News news);

	void deleteNews(int id_news);

	int totalSearch(String key);

	List<News> searchNews(String key, int limit, int offset);

	void updateViews(News news);

}
