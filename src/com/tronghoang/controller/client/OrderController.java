package com.tronghoang.controller.client;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tronghoang.dao.OrderDao;
import com.tronghoang.dao.OrderDetailDao;
import com.tronghoang.dao.ProductDao;
import com.tronghoang.dao.impl.OrderDaoImpl;
import com.tronghoang.dao.impl.OrderDetailDaoImpl;
import com.tronghoang.dao.impl.ProductDaoImpl;
import com.tronghoang.library.RandomID;
import com.tronghoang.library.SendMail;
import com.tronghoang.model.DetailOrder;
import com.tronghoang.model.Order;
import com.tronghoang.model.Product;
import com.tronghoang.model.User;

@WebServlet(urlPatterns = "/traodoi/shop/cart/checkout")
public class OrderController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/client/checkout.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String mail = req.getParameter("mail");

		Order order = new Order();
		order.setFullname(fullname);
		order.setPhone(phone);
		order.setAddress(address);

		HttpSession session = req.getSession();
		List<DetailOrder> cartList = (List<DetailOrder>) session.getAttribute("cartList");
		float total = 0;
		int status = 1;
		for (DetailOrder orderDetail : cartList) {
			total += orderDetail.getTotal_product();
		}
		order.setTotal(total);

		User customer = (User) session.getAttribute("loginClient");
		order.setCustomer(customer);

		Date date = new Date();
		DateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String date_created = dateformat.format(date);
		order.setDate_created(date_created);
		String idorder = date.getSeconds() + RandomID.randomAlphaNumeric(6);
		System.out.println(idorder);
		order.setIdorder(idorder);
		order.setMail(mail);
		OrderDao orderDao = new OrderDaoImpl();
		orderDao.addOrder(order);

		for (DetailOrder orderDetail : cartList) {
			OrderDetailDao detailOrderDao = new OrderDetailDaoImpl();
			DetailOrder detailOrder = new DetailOrder();
			detailOrder.setProduct(orderDetail.getProduct());
			detailOrder.setAmount(orderDetail.getAmount());
			detailOrder.setTotal_product(orderDetail.getTotal_product());
			detailOrder.setIdorder(order);
			detailOrder.setStatus(status);
			System.out.println(order.getIdorder());
			if (orderDetail.getProduct().getAmount() >= orderDetail.getAmount()) {
				detailOrderDao.addOrderDetail(detailOrder);
				int amount = orderDetail.getProduct().getAmount() - orderDetail.getAmount();
				Product product = new Product();
				product.setAmount(amount);
				product.setId(orderDetail.getProduct().getId());
				product.setCategory(orderDetail.getProduct().getCategory());
				product.setName(orderDetail.getProduct().getName());
				product.setPrice(orderDetail.getProduct().getPrice());
				product.setDes(orderDetail.getProduct().getDes());
				product.setImage(orderDetail.getProduct().getImage());
				product.setAmount(amount);
				product.setUser(orderDetail.getProduct().getUser());
				product.setDate_created(orderDetail.getProduct().getDate_created());
				product.setStatus(orderDetail.getProduct().getStatus());
				ProductDao productDao = new ProductDaoImpl();
				productDao.update(product);
			}
		}
		String text = "Mã đơn hàng của bạn là : " + idorder + "Tổng tiền là : " + order.getTotal();
		SendMail sm = new SendMail();
		sm.sendMail(mail, "Đơn hàng từ Hoa Lan VN", text);
		session.removeAttribute("cartList");

		resp.sendRedirect(req.getContextPath() + "/traodoi/shop?mess=successorder");

	}
}
