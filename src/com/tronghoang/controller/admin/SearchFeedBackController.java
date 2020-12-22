package com.tronghoang.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.FeedBackDao;
import com.tronghoang.dao.impl.FeedBackDaoImpl;
import com.tronghoang.library.Pagination;
import com.tronghoang.model.FeedBack;

@WebServlet(urlPatterns = "/admin/feedback/search")
public class SearchFeedBackController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		req.setAttribute("key", key);
		String pageParam = req.getParameter("page");
		int page;
		int limit = 10;
		FeedBackDao feedbackDao = new FeedBackDaoImpl();

		if (pageParam != null) {
			if (pageParam == "") {
				page = 1;
			} else {
				page = Integer.parseInt(pageParam);
			}

		} else {
			page = 1;

		}
		req.setAttribute("page", page);
		Pagination pagination = new Pagination();

		int total = feedbackDao.totalSearch(key);
		int totalPage = pagination.totalPage(total, limit);
		req.setAttribute("totalPage", totalPage);
		int offset = pagination.offset(page, limit, totalPage);
		List<Integer> listPage = pagination.listPage(totalPage);
		req.setAttribute("pageList", listPage);
		List<FeedBack> feedback = feedbackDao.searchFeedBack(key, limit, offset);
		req.setAttribute("feedbackListSearch", feedback);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/searchFeedback.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		if (key == "") {
			resp.sendRedirect(req.getContextPath() + "/admin/feedback/search?key=" + "");
		} else {
			resp.sendRedirect(req.getContextPath() + "/admin/feedback/search?key=" + key);
		}
	}
}
