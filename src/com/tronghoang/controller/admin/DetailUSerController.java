package com.tronghoang.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.UserDao;
import com.tronghoang.dao.impl.UserDaoImpl;
import com.tronghoang.model.User;

@WebServlet(urlPatterns = "/admin/user/detail")
public class DetailUSerController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_user = Integer.parseInt(req.getParameter("id_user"));
		UserDao userDao = new UserDaoImpl();
		User user = userDao.getUserId(id_user);
		req.setAttribute("user", user);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/detailUser.jsp");
		requestDispatcher.forward(req, resp);
	}
}
