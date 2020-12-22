package com.tronghoang.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tronghoang.model.DetailOrder;

@WebServlet(urlPatterns = "/traodoi/shop/cart/delete")
public class DeleteProductCartController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		HttpSession session = req.getSession();
		List<DetailOrder> cartList = (List<DetailOrder>) session.getAttribute("cartList");
		for (int i = 0; i < cartList.size(); i++) {
			DetailOrder detail = cartList.get(i);
			if (id == detail.getProduct().getId()) {
				cartList.remove(detail);
			}

		}
		resp.sendRedirect("/HoaLanVN/traodoi/shop/cart");

	}
}
