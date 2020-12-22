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

@WebServlet(urlPatterns = "/admin/feedback")
public class FeedBackController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageParam = req.getParameter("page");
		int status = Integer.parseInt(req.getParameter("status"));
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

		int totalUser = feedbackDao.totalFeedBackWait();
		int totalPage = pagination.totalPage(totalUser, limit);
		int offset = pagination.offset(page, limit, totalPage);
		req.setAttribute("totalPage", totalPage);
		List<Integer> listPage = pagination.listPage(totalPage);
		req.setAttribute("pageList", listPage);

		List<FeedBack> feedback = feedbackDao.getWait(status, limit, offset);
		req.setAttribute("feebackWaitList", feedback);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/feedbackWait.jsp");
		requestDispatcher.forward(req, resp);
	}
}
