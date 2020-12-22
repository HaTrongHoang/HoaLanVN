package com.tronghoang.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.FeedBackDao;
import com.tronghoang.dao.impl.FeedBackDaoImpl;
import com.tronghoang.model.FeedBack;

@WebServlet(urlPatterns = "/admin/feedback/detail")
public class DetailFeedBackController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_feedback = Integer.parseInt(req.getParameter("id_feedback"));
		FeedBackDao feedbackDao = new FeedBackDaoImpl();
		FeedBack feedback = feedbackDao.getFeedBackId(id_feedback);
		req.setAttribute("feedback", feedback);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/detailFeedback.jsp");
		requestDispatcher.forward(req, resp);
	}
}
