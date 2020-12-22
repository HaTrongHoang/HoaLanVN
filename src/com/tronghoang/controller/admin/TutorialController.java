package com.tronghoang.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.CategoryDao;
import com.tronghoang.dao.TutorialDao;
import com.tronghoang.dao.impl.CategoryDaoImpl;
import com.tronghoang.dao.impl.TutorialDaoImpl;
import com.tronghoang.library.Pagination;
import com.tronghoang.model.Category;
import com.tronghoang.model.Tutorial;

@WebServlet(urlPatterns = "/admin/tutorial")
public class TutorialController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mess = req.getParameter("mess");
		String pageParam = req.getParameter("page");
		int page;
		int category_id = Integer.parseInt(req.getParameter("category_id"));
		req.setAttribute("category", category_id);
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

		int totaltutorial = tutorialDao.totalTutorial(category_id);
		int totalPage = pagination.totalPage(totaltutorial, limit);
		int offset = pagination.offset(page, limit, totalPage);
		req.setAttribute("totalPage", totalPage);
		List<Integer> listPage = pagination.listPage(totalPage);
		req.setAttribute("pageList", listPage);

		List<Tutorial> tutorial = tutorialDao.getAll(limit, offset, category_id);
		req.setAttribute("tutorialList", tutorial);
		CategoryDao categoryDao = new CategoryDaoImpl();
		Category categoryId = categoryDao.getCategoryById(category_id);
		req.setAttribute("categoryName", categoryId);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/tutorial.jsp");
		requestDispatcher.forward(req, resp);
	}
}
