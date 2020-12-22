package com.tronghoang.controller.client;

import java.io.IOException;
import java.util.ArrayList;
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
import com.tronghoang.model.DetailOrder;
import com.tronghoang.model.Product;

@WebServlet(urlPatterns = "/traodoi/shop/cart")
public class CartController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("id") != null) {

			int product_id = Integer.parseInt(req.getParameter("id"));
			int amount = 0;
			if (req.getParameter("amount") == null) {
				amount = 1;
			} else {
				amount = Integer.parseInt(req.getParameter("amount"));
			}
			ProductDao productDao = new ProductDaoImpl();
			Product product = productDao.getId(product_id);
			float price = product.getPrice();
			HttpSession session = req.getSession();
			List<DetailOrder> cartList = (List<DetailOrder>) session.getAttribute("cartList");
			if (cartList == null) {
				List<DetailOrder> detailOrderList = new ArrayList<DetailOrder>();
				DetailOrder detailOrder = new DetailOrder();
				detailOrder.setProduct(product);
				detailOrder.setAmount(amount);
				detailOrder.setTotal_product(price * amount);
				System.out.println("giá" + product.getPrice());
				detailOrderList.add(detailOrder);
				session.setAttribute("cartList", detailOrderList);
			} else if (cartList != null) {
				boolean check = false;
				for (int i = 0; i < cartList.size(); i++) {
					DetailOrder detailOrder = cartList.get(i);
					if (product_id == detailOrder.getProduct().getId()) {
						amount = detailOrder.getAmount() + 1;
						detailOrder.setAmount(amount);
						detailOrder.setProduct(product);
						detailOrder.setTotal_product(detailOrder.getProduct().getPrice() * amount);
						session.setAttribute("cartList", cartList);
						check = true;
					}
				}
				if (check == false) {
					DetailOrder Order = new DetailOrder();
					Order.setProduct(product);
					Order.setAmount(1);
					Order.setTotal_product(product.getPrice());
					cartList.add(Order);
					session.setAttribute("cartList", cartList);
				}
			}
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/client/cartList.jsp");
			dispatcher.forward(req, resp);
		} else {
			HttpSession session = req.getSession();
			List<DetailOrder> cartList = (List<DetailOrder>) session.getAttribute("cartList");
			session.setAttribute("cartList", cartList);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/client/cartList.jsp");
			dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int product_id = Integer.parseInt(req.getParameter("id"));
		int amount = Integer.parseInt(req.getParameter("amount"));
		ProductDao productDao = new ProductDaoImpl();
		Product product = productDao.getId(product_id);
		if (product.getAmount() >= amount) {
			resp.sendRedirect("/HoaLanVN/traodoi/shop/cart?id=" + product_id + "&amount=" + amount);
		} else {
			resp.sendRedirect("/HoaLanVN/traodoi/shop/product?id=" + product_id + "&mess=amount");
		}

	}
}
