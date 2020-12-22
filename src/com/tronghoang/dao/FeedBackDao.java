package com.tronghoang.dao;

import java.util.List;

import com.tronghoang.model.FeedBack;

public interface FeedBackDao {

	List<FeedBack> getWait(int status, int limit, int offset);

	int totalFeedBackWait();

	void addFeedBack(FeedBack feedback);

	void updateFeedBack(FeedBack feedback);

	void deleteFeedBack(int id_feedback);

	int totalSearch(String key);

	List<FeedBack> searchFeedBack(String key, int limit, int offset);

	FeedBack getFeedBackId(int id_feedback);

}
