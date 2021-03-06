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

@WebServlet(urlPatterns = "/admin/user/delete")

public class DeleteUserController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_user = Integer.parseInt(req.getParameter("id_user"));
		UserDao userDao = new UserDaoImpl();
		userDao.deleteUser(id_user);
		System.out.println("xoa user id:"+ id_user);
		resp.sendRedirect(req.getContextPath() + "/admin/user?mess=delete");
	}
}
