package com.tronghoang.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.FeedBackDao;
import com.tronghoang.dao.impl.FeedBackDaoImpl;

@WebServlet(urlPatterns = "/admin/feedback/delete")
public class DeleteFeedBackController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_feedback = Integer.parseInt(req.getParameter("id_feedback"));
		FeedBackDao feedbackDao = new FeedBackDaoImpl();
		feedbackDao.deleteFeedBack(id_feedback);
		resp.sendRedirect(req.getContextPath() + "/admin/feedback?status=1&mess=delete");
	}
}
