package com.tronghoang.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.ProductDao;
import com.tronghoang.dao.impl.ProductDaoImpl;
import com.tronghoang.model.Product;

@WebServlet(urlPatterns = "/admin/product/update")
public class UpdateProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String status = req.getParameter("status");
		ProductDao productDao = new ProductDaoImpl();
		Product product = productDao.getId(id);
		productDao.updateStatus(status, id);
		resp.sendRedirect(req.getContextPath() + "/admin/product?status=1");
	}
}
