package com.tronghoang.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.OrderDetailDao;
import com.tronghoang.dao.impl.OrderDetailDaoImpl;
import com.tronghoang.library.Pagination;
import com.tronghoang.model.DetailOrder;

@WebServlet(urlPatterns = "/traodoi/shop/gianhang/donhang")
public class StatusOrderController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int status = Integer.parseInt(req.getParameter("status"));
		String pageParam = req.getParameter("page");
		int page;
		req.setAttribute("status", status);
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

		int totalStatus = detailDao.totalStatus(status);
		int totalPage = pagination.totalPage(totalStatus, limit);
		int offset = pagination.offset(page, limit, totalPage);
		req.setAttribute("totalPage", totalPage);
		List<Integer> listPage = pagination.listPage(totalPage);
		req.setAttribute("pageList", listPage);

		List<DetailOrder> statusList = detailDao.getStatus(status, limit, offset);
		req.setAttribute("statusList", statusList);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/client/donhang.jsp");
		requestDispatcher.forward(req, resp);

	}
}
