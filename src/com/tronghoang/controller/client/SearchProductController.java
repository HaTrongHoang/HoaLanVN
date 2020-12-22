package com.tronghoang.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.ProductDao;
import com.tronghoang.dao.impl.ProductDaoImpl;
import com.tronghoang.library.Pagination;
import com.tronghoang.model.Product;

@WebServlet(urlPatterns = "/traodoi/shop/search")
public class SearchProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		req.setAttribute("key", key);
		String status = req.getParameter("status");
		req.setAttribute("status", status);
		String pageParam = req.getParameter("page");
		int page;
		int limit = 10;
		ProductDao productDao = new ProductDaoImpl();

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

		int total = productDao.totalSearch(key, status);
		int totalPage = pagination.totalPage(total, limit);
		req.setAttribute("totalPage", totalPage);
		int offset = pagination.offset(page, limit, totalPage);
		List<Integer> listPage = pagination.listPage(totalPage);
		req.setAttribute("pageList", listPage);
		List<Product> product = productDao.getSearch(key, status, limit, offset);
		req.setAttribute("productList", product);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/client/searchProduct.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		String status = req.getParameter("status");
		if (key == "") {
			resp.sendRedirect(req.getContextPath() + "/traodoi/shop/search?key=" + "" + "&status=" + status);
		} else {
			resp.sendRedirect(req.getContextPath() + "/traodoi/shop/search?key=" + key + "&status=" + status);
		}
	}
}
