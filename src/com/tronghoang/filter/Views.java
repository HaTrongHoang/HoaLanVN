package com.tronghoang.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tronghoang.dao.TutorialDao;
import com.tronghoang.dao.impl.TutorialDaoImpl;
import com.tronghoang.model.Tutorial;

/**
 * Servlet Filter implementation class Views
 */
@WebFilter("/tutorial/detail")
public class Views implements Filter {

	/**
	 * Default constructor.
	 */
	public Views() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		TutorialDao tutorialDao = new TutorialDaoImpl();
		int id_tutorial = Integer.parseInt(req.getParameter("id_tutorial"));
		Tutorial tutorialViews = tutorialDao.getTutorialId(id_tutorial);
		Tutorial tutorial = new Tutorial();
		int views = tutorialViews.getView() + 1;
		tutorial.setId_tutorial(id_tutorial);
		tutorial.setView(views);
		tutorialDao.updateViews(tutorial);
		chain.doFilter(req, resp);

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
