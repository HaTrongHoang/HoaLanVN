package com.tronghoang.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.IntroduceDao;
import com.tronghoang.dao.impl.IntroduceDaoImpl;
import com.tronghoang.model.Introduce;

@WebServlet(urlPatterns = "/admin/introduce/update")
public class UpdateIntroduceController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IntroduceDao introduceDao = new IntroduceDaoImpl();
		Introduce introduce = introduceDao.get(1);
		req.setAttribute("introduce", introduce);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/updateIntroduce.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String content = req.getParameter("content");
		Introduce introduce = new Introduce();
		introduce.setContent(content);
		introduce.setId(1);
		IntroduceDao introduceDao = new IntroduceDaoImpl();
		introduceDao.update(introduce);
		resp.sendRedirect(req.getContextPath() + "/admin/introduce");
	}
}
