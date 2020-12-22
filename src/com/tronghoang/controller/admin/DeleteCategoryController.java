package com.tronghoang.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.CategoryDao;
import com.tronghoang.dao.impl.CategoryDaoImpl;
@WebServlet(urlPatterns = "/admin/category/delete")
public class DeleteCategoryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_category = Integer.parseInt(req.getParameter("id_category"));
		CategoryDao categoryDao = new CategoryDaoImpl();
		categoryDao.deleteCategory(id_category);
		resp.sendRedirect(req.getContextPath() + "/admin/category?mess=delete");
	}

}
