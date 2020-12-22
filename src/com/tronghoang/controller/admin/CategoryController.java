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
import com.tronghoang.dao.impl.CategoryDaoImpl;
import com.tronghoang.library.Pagination;
import com.tronghoang.model.Category;
@WebServlet(urlPatterns = "/admin/category")
public class CategoryController extends HttpServlet {
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
		CategoryDao categoryDao=new CategoryDaoImpl();

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

		int totalCategory = categoryDao.totalCategory();
		int totalPage = pagination.totalPage(totalCategory, limit);
		int offset = pagination.offset(page, limit, totalPage);
		req.setAttribute("totalPage", totalPage);
		List<Integer> listPage = pagination.listPage(totalPage);
		req.setAttribute("pageList", listPage);

		List<Category> category = categoryDao.getAll(limit, offset);
		req.setAttribute("categoryList", category);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/category.jsp");
		requestDispatcher.forward(req, resp);
	}
}
