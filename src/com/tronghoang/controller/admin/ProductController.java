package com.tronghoang.controller.admin;

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

@WebServlet(urlPatterns = "/admin/product")
public class ProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String status = req.getParameter("status");
		String pageParam = req.getParameter("page");
		req.setAttribute("status", status);
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

		int totalProduct = productDao.totalProductAll(status);
		int totalPage = pagination.totalPage(totalProduct, limit);
		int offset = pagination.offset(page, limit, totalPage);
		req.setAttribute("totalPage", totalPage);
		List<Integer> listPage = pagination.listPage(totalPage);
		req.setAttribute("pageList", listPage);

		List<Product> product = productDao.getAll(status, limit, offset);
		req.setAttribute("productList", product);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/product.jsp");
		requestDispatcher.forward(req, resp);
	}
}
