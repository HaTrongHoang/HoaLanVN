package com.tronghoang.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.UserDao;
import com.tronghoang.dao.impl.UserDaoImpl;
import com.tronghoang.library.Pagination;
import com.tronghoang.model.User;

@WebServlet(urlPatterns = "/admin/user")
public class UserController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String mess = req.getParameter("mess");
		String pageParam = req.getParameter("page");
		int page;
		if (mess != null && mess.equals("success")) {
			req.setAttribute("mess", "alert('them thanh cong');");
		}
		if (mess != null && mess.equals("delete")) {
			req.setAttribute("mess", "alert('xoa thanh cong');");
		}
		if (mess != null && mess.equals("update")) {
			req.setAttribute("mess", "alert('sua thanh cong');");
		}
		int limit = 10;
		UserDao userDao = new UserDaoImpl();

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

		int totalUser = userDao.totalUser();
		int totalPage = pagination.totalPage(totalUser, limit);
		int offset = pagination.offset(page, limit, totalPage);
		req.setAttribute("totalPage", totalPage);
		List<Integer> listPage = pagination.listPage(totalPage);
		req.setAttribute("pageList", listPage);

		List<User> user = userDao.getAll(limit, offset);
		req.setAttribute("userList", user);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/user.jsp");
		requestDispatcher.forward(req, resp);
	}
}
