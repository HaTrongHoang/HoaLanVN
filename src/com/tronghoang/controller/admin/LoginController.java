package com.tronghoang.controller.admin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tronghoang.dao.UserDao;
import com.tronghoang.dao.impl.UserDaoImpl;
import com.tronghoang.library.MD5Encoder;
import com.tronghoang.model.User;

@WebServlet(urlPatterns = "/login-admin")
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/login.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MD5Encoder md5 = new MD5Encoder();
		String username = req.getParameter("username");
		String pass = req.getParameter("password");
		System.out.println(username);
		System.out.println(pass);
		try {
			String password = md5.md5Encoder(pass);
			System.out.println(password);
			UserDao userDao = new UserDaoImpl();
			User user = userDao.getUser(username);

			HttpSession session = req.getSession();

			if (user != null && user.getPassword().equals(password)) {
				session.setAttribute("loginAdmin", user);
				resp.sendRedirect(req.getContextPath() + "/admin/home");
			} else {
				resp.sendRedirect(req.getContextPath() + "/login-admin");
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
