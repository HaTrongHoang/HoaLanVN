package com.tronghoang.controller.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.ProductDao;
import com.tronghoang.dao.impl.ProductDaoImpl;

@WebServlet(urlPatterns = "/traodoi/shop/gianhang/delete")
public class DeleteProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		ProductDao productDao = new ProductDaoImpl();
		productDao.delete(id);
		resp.sendRedirect(req.getContextPath() + "/traodoi/shop/gianhang?mess=delete");
	}
}
