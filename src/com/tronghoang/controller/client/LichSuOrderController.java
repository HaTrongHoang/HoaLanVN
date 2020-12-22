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

import com.tronghoang.dao.OrderDetailDao;
import com.tronghoang.dao.impl.OrderDetailDaoImpl;
import com.tronghoang.library.Pagination;
import com.tronghoang.model.DetailOrder;
import com.tronghoang.model.User;

@WebServlet(urlPatterns = "/traodoi/shop/order")
public class LichSuOrderController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageParam = req.getParameter("page");
		int page;
		HttpSession session = req.getSession();
		User userLogin = (User) session.getAttribute("loginClient");
		int id_user = userLogin.getId_user();
		System.out.println("id" + id_user);
		req.setAttribute("id_user", id_user);
		int limit = 10;
		OrderDetailDao detailDao = new OrderDetailDaoImpl();

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

		int totalOrder = detailDao.totalAllOrder(id_user);
		int totalPage = pagination.totalPage(totalOrder, limit);
		int offset = pagination.offset(page, limit, totalPage);
		req.setAttribute("totalPage", totalPage);
		List<Integer> listPage = pagination.listPage(totalPage);
		req.setAttribute("pageList", listPage);

		List<DetailOrder> orderList = detailDao.getAllOrder(id_user, limit, offset);
		req.setAttribute("orderList", orderList);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/client/lichsumuahang.jsp");
		requestDispatcher.forward(req, resp);
	}
}
