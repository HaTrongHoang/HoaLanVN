package com.tronghoang.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.NewsDao;
import com.tronghoang.dao.impl.NewsDaoImpl;
import com.tronghoang.model.News;

@WebServlet(urlPatterns = "/news/detail")
public class DetailNewsController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_news = Integer.parseInt(req.getParameter("id_news"));
		NewsDao newsDao = new NewsDaoImpl();
		News news = newsDao.getNewsId(id_news);
		req.setAttribute("news", news);

		List<News> newsList = newsDao.getAll(5, 0);
		req.setAttribute("newsList", newsList);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/client/detailNews.jsp");
		requestDispatcher.forward(req, resp);
	}
}
