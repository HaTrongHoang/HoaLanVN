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

@WebServlet(urlPatterns = "/admin/contact/update")
public class UpdateContactController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ContactDao contactDao = new ContactDaoImpl();
		Contact contact = contactDao.getById(1);
		req.setAttribute("contact", contact);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/updateContact.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		Contact contact = new Contact();
		contact.setPhone(phone);
		contact.setEmail(email);
		contact.setAddress(address);
		contact.setId(1);
		ContactDao contactDao = new ContactDaoImpl();
		contactDao.updateContact(contact);
		resp.sendRedirect(req.getContextPath() + "/admin/contact");

	}
}
