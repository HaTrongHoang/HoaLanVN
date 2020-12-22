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

import com.tronghoang.dao.NewsDao;
import com.tronghoang.dao.impl.NewsDaoImpl;
import com.tronghoang.model.News;

/**
 * Servlet Filter implementation class ViewsNews
 */
@WebFilter("/news/detail")
public class ViewsNews implements Filter {

	/**
	 * Default constructor.
	 */
	public ViewsNews() {
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
		NewsDao newsDao = new NewsDaoImpl();
		int id_news = Integer.parseInt(req.getParameter("id_news"));
		News newsViews = newsDao.getNewsId(id_news);
		News news = new News();
		int views = newsViews.getView() + 1;
		news.setId_news(id_news);
		news.setView(views);
		newsDao.updateViews(news);
		chain.doFilter(req, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
