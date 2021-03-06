package com.tronghoang.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.TutorialDao;
import com.tronghoang.dao.impl.TutorialDaoImpl;
import com.tronghoang.model.Tutorial;

@WebServlet(urlPatterns = "/tutorial/detail")
public class DetailTutorialController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_tutorial = Integer.parseInt(req.getParameter("id_tutorial"));
		TutorialDao tutorialDao = new TutorialDaoImpl();
		Tutorial tutorial = tutorialDao.getTutorialId(id_tutorial);
		req.setAttribute("tutorial", tutorial);

		List<Tutorial> tutorialList = tutorialDao.getAll(5, 0, tutorial.getCategory_id().getId_category());
		req.setAttribute("tutorialList", tutorialList);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/client/detailTutorial.jsp");
		requestDispatcher.forward(req, resp);
	}
}
