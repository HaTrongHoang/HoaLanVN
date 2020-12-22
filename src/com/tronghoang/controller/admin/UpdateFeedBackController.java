package com.tronghoang.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tronghoang.dao.FeedBackDao;
import com.tronghoang.dao.impl.FeedBackDaoImpl;
import com.tronghoang.model.FeedBack;
import com.tronghoang.model.User;

@WebServlet(urlPatterns = "/admin/feedback/update")
public class UpdateFeedBackController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_feedback = Integer.parseInt(req.getParameter("id_feedback"));
		FeedBack feedback = new FeedBack();
		feedback.setId_feedback(id_feedback);
		feedback.setStatus(2);

		HttpSession session = req.getSession();
		User userLogin = (User) session.getAttribute("loginAdmin");
		feedback.setId_user(userLogin.getFullname());
		FeedBackDao feedbackDao = new FeedBackDaoImpl();
		feedbackDao.updateFeedBack(feedback);
		resp.sendRedirect(req.getContextPath() + "/admin/feedback?status=1&mess=update");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
