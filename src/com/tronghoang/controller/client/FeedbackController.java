package com.tronghoang.controller.client;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.FeedBackDao;
import com.tronghoang.dao.impl.FeedBackDaoImpl;
import com.tronghoang.model.FeedBack;

@WebServlet(urlPatterns = "/feedback")
public class FeedbackController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/client/feedBack.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fullname = req.getParameter("fullname");
		String mail = req.getParameter("mail");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		FeedBack feedback = new FeedBack();
		feedback.setFullname(fullname);
		feedback.setMail(mail);
		feedback.setTitle(title);
		feedback.setContent(content);
		feedback.setStatus(1);

		Date date = new Date();
		DateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String date_created = dateformat.format(date);
		feedback.setCreated(date_created);
		FeedBackDao feedbackDao = new FeedBackDaoImpl();
		feedbackDao.addFeedBack(feedback);
		resp.sendRedirect(req.getContextPath() + "/home");
	}
}
