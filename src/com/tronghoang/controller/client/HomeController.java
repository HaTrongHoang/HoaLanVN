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
import com.tronghoang.dao.TutorialDao;
import com.tronghoang.dao.impl.NewsDaoImpl;
import com.tronghoang.dao.impl.TutorialDaoImpl;
import com.tronghoang.library.Pagination;
import com.tronghoang.model.News;
import com.tronghoang.model.Tutorial;

@WebServlet(urlPatterns = "/home")
public class HomeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageParam = req.getParameter("page");
		int page;
		int limit = 10;
		TutorialDao tutorialDao = new TutorialDaoImpl();

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

		int totaltutorial = tutorialDao.totalTutorialAll();
		int totalPage = pagination.totalPage(totaltutorial, limit);
		int offset = pagination.offset(page, limit, totalPage);
		req.setAttribute("totalPage", totalPage);
		List<Integer> listPage = pagination.listPage(totalPage);
		req.setAttribute("pageList", listPage);

		List<Tutorial> tutorial = tutorialDao.getAllHome(limit, offset);
		req.setAttribute("tutorialList", tutorial);

		NewsDao newDao = new NewsDaoImpl();
		List<News> news = newDao.getAll(5, 0);
		req.setAttribute("newsList", news);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/client/home.jsp");
		requestDispatcher.forward(req, resp);
	}
}
