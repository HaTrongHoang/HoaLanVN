package com.tronghoang.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.CategoryDao;
import com.tronghoang.dao.impl.CategoryDaoImpl;
import com.tronghoang.model.Category;

@WebServlet(urlPatterns = "/admin/category/update")
public class UpdateCategoryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_category = Integer.parseInt(req.getParameter("id_category"));
		CategoryDao categoryDao = new CategoryDaoImpl();
		Category categoryId = categoryDao.getCategoryById(id_category);
		req.setAttribute("category", categoryId);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/updateCategory.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int id_category = Integer.parseInt(req.getParameter("id_category"));
		CategoryDao categoryDao = new CategoryDaoImpl();
		if (categoryDao.getCategoryName(name) != null) {
			resp.sendRedirect(req.getContextPath() + "/admin/category?mess=exist");
		} else {
			Category category = new Category();
			category.setName(name);
			category.setId_category(id_category);
			categoryDao.updateCategory(category);
			resp.sendRedirect(req.getContextPath() + "/admin/category?mess=update");
		}
	}

}
