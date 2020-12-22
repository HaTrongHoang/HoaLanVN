package com.tronghoang.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.CategoryDao;
import com.tronghoang.dao.FeedBackDao;
import com.tronghoang.dao.NewsDao;
import com.tronghoang.dao.ProductDao;
import com.tronghoang.dao.TutorialDao;
import com.tronghoang.dao.UserDao;
import com.tronghoang.dao.impl.CategoryDaoImpl;
import com.tronghoang.dao.impl.FeedBackDaoImpl;
import com.tronghoang.dao.impl.NewsDaoImpl;
import com.tronghoang.dao.impl.ProductDaoImpl;
import com.tronghoang.dao.impl.TutorialDaoImpl;
import com.tronghoang.dao.impl.UserDaoImpl;

@WebServlet(urlPatterns = "/admin/home")
public class HomeCotroller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		TutorialDao tutorialDao = new TutorialDaoImpl();
		int totalTutorial = tutorialDao.totalSearch("");
		req.setAttribute("TKtotalTutorial", totalTutorial);

		NewsDao newsDao = new NewsDaoImpl();
		int totalNews = newsDao.totalSearch("");
		req.setAttribute("TKtotalNews", totalNews);

		ProductDao productDao = new ProductDaoImpl();
		int totalProduct1 = productDao.totalProductAll("1");
		req.setAttribute("TKtotalProduct1", totalProduct1);
		int totalProduct2 = productDao.totalProductAll("2");
		req.setAttribute("TKtotalProduct2", totalProduct2);

		FeedBackDao feedbackDao = new FeedBackDaoImpl();
		int totalFeedback = feedbackDao.totalSearch("");
		req.setAttribute("TKtotalFeedback", totalFeedback);

		UserDao userDao = new UserDaoImpl();
		int totalUser = userDao.totalSearch("");
		req.setAttribute("TKtotalUser", totalUser);

		CategoryDao categoryDao = new CategoryDaoImpl();
		int TKtotalDanhmuc = categoryDao.totalSearch("");
		req.setAttribute("TKtotalDanhmuc", TKtotalDanhmuc);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/index.jsp");
		requestDispatcher.forward(req, resp);
	}
}
