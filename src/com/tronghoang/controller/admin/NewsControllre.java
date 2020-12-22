package com.tronghoang.controller.admin;

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
import com.tronghoang.library.Pagination;
import com.tronghoang.model.News;

@WebServlet(urlPatterns = "/admin/news")
public class NewsControllre extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mess = req.getParameter("mess");
		String pageParam = req.getParameter("page");
		int page;
		if (mess != null && mess.equals("success")) {
			req.setAttribute("mess", "alert('them thanh cong');");
		}
		if (mess != null && mess.equals("delete")) {
			req.setAttribute("mess", "alert('xoa thanh cong');");
		}
		if (mess != null && mess.equals("update")) {
			req.setAttribute("mess", "alert('sua thanh cong');");
		}
		int limit = 10;
		NewsDao newDao = new NewsDaoImpl();

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

		int totalNews = newDao.totalNews();
		int totalPage = pagination.totalPage(totalNews, limit);
		int offset = pagination.offset(page, limit, totalPage);
		req.setAttribute("totalPage", totalPage);
		List<Integer> listPage = pagination.listPage(totalPage);
		req.setAttribute("pageList", listPage);

		List<News> news = newDao.getAll(limit, offset);
		req.setAttribute("newsList", news);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/news.jsp");
		requestDispatcher.forward(req, resp);
	}
}
