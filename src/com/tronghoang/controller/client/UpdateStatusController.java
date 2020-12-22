package com.tronghoang.controller.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.OrderDetailDao;
import com.tronghoang.dao.ProductDao;
import com.tronghoang.dao.impl.OrderDetailDaoImpl;
import com.tronghoang.dao.impl.ProductDaoImpl;
import com.tronghoang.model.DetailOrder;
import com.tronghoang.model.Product;

@WebServlet(urlPatterns = "/traodoi/shop/gianhang/donghang/update")
public class UpdateStatusController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		int status = Integer.parseInt(req.getParameter("status"));
		OrderDetailDao orderdetailDao = new OrderDetailDaoImpl();
		orderdetailDao.updateStatus(id, status);
		if (status == 0) {
			DetailOrder detailOrder = orderdetailDao.getId(id);
			ProductDao productDao = new ProductDaoImpl();
			Product product = productDao.getId(detailOrder.getProduct().getId());

			int amount = product.getAmount() + detailOrder.getAmount();
			product.setAmount(amount);
			productDao.update(product);
		}
		resp.sendRedirect("/HoaLanVN/traodoi/shop/gianhang/donhang?status=" + status);
	}
}
