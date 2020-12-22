package com.tronghoang.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.ContactDao;
import com.tronghoang.dao.impl.ContactDaoImpl;
import com.tronghoang.model.Contact;

@WebServlet(urlPatterns = "/admin/contact")
public class ContactController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ContactDao contactDao = new ContactDaoImpl();
		Contact contact = contactDao.getById(1);
		req.setAttribute("contact", contact);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/contact.jsp");
		requestDispatcher.forward(req, resp);
	}
}
