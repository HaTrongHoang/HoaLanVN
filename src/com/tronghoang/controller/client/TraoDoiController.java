package com.tronghoang.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tronghoang.dao.ProductDao;
import com.tronghoang.dao.impl.ProductDaoImpl;
import com.tronghoang.library.Pagination;
import com.tronghoang.model.Product;
import com.tronghoang.model.User;

@WebServlet(urlPatterns = "/traodoi/shop")
public class TraoDoiController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageParam = req.getParameter("page");
		int page;
		int limit = 12;
		String status = "2";
		HttpSession session = req.getSession();
		User userLogin = (User) session.getAttribute("loginClient");

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
		req.setAttribute("productListAll", product);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/client/traodoi.jsp");
		dispatcher.forward(req, resp);
	}
}
