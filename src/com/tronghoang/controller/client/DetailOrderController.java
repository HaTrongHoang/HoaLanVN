package com.tronghoang.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.OrderDao;
import com.tronghoang.dao.OrderDetailDao;
import com.tronghoang.dao.impl.OrderDaoImpl;
import com.tronghoang.dao.impl.OrderDetailDaoImpl;
import com.tronghoang.model.DetailOrder;
import com.tronghoang.model.Order;

@WebServlet(urlPatterns = "/traodoi/shop/order/detail")
public class DetailOrderController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idorder = req.getParameter("idorder");
		OrderDao orderDao = new OrderDaoImpl();
		Order order = orderDao.getId(idorder);
		req.setAttribute("order", order);
		OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();
		List<DetailOrder> detailOrder = orderDetailDao.getIdOrder(idorder);
		req.setAttribute("detailOrder", detailOrder);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/client/detailOrder.jsp");
		dispatcher.forward(req, resp);
	}
}
