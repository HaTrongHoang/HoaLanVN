package com.tronghoang.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tronghoang.dao.CategoryDao;
import com.tronghoang.dao.impl.CategoryDaoImpl;
import com.tronghoang.model.Category;
import com.tronghoang.model.User;

@WebServlet(urlPatterns = "/admin/category/add")
public class AddCategoryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/addCategory.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		System.out.println(name);
		Category category = new Category();
		category.setName(name);

		HttpSession session = req.getSession();
		User userLogin = (User) session.getAttribute("loginAdmin");
		category.setId_user(userLogin.getFullname());

		CategoryDao categoryDao = new CategoryDaoImpl();
		if (categoryDao.getCategoryName(name) != null) {
			resp.sendRedirect(req.getContextPath() + "/admin/category?mess=exist");
		} else {
			categoryDao.addCategory(category);
			resp.sendRedirect(req.getContextPath() + "/admin/category?mess=addsuccess");
		}

	}
}
