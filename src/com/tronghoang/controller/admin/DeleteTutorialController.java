package com.tronghoang.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.TutorialDao;
import com.tronghoang.dao.impl.TutorialDaoImpl;
@WebServlet(urlPatterns = "/admin/tutorial/delete")
public class DeleteTutorialController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_tutorial = Integer.parseInt(req.getParameter("id_tutorial"));
		int category_id = Integer.parseInt(req.getParameter("category_id"));
		TutorialDao tutorialDao = new TutorialDaoImpl();
		tutorialDao.deleteTutorial(id_tutorial);
		System.out.println("xoa user id:" + id_tutorial);
		resp.sendRedirect(req.getContextPath() + "/admin/tutorial?category_id="+category_id+"&mess=delete");
	}
}
