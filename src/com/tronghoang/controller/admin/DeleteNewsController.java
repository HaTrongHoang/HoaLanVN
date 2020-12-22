package com.tronghoang.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.NewsDao;
import com.tronghoang.dao.impl.NewsDaoImpl;

@WebServlet(urlPatterns = "/admin/news/delete")
public class DeleteNewsController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_news = Integer.parseInt(req.getParameter("id_news"));
		NewsDao newsDao = new NewsDaoImpl();
		newsDao.deleteNews(id_news);
		System.out.println("xoa user id:" + id_news);
		resp.sendRedirect(req.getContextPath() + "/admin/news?mess=delete");
	}
}
