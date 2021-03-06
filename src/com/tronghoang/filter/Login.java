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
import javax.servlet.http.HttpSession;

import com.tronghoang.model.User;

/**
 * Servlet Filter implementation class Login
 */
@WebFilter("/admin/*")
public class Login implements Filter {

	/**
	 * Default constructor.
	 */
	public Login() {
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
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("loginAdmin");
		if (user != null) {
			if (user.getRole() == 0) {
				req.setAttribute("disabledAdmin", "disabled");
				chain.doFilter(req, resp);
			} else if (user.getRole() == 1) {
				req.setAttribute("disabledMember", "disabled");
				chain.doFilter(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + "/login-admin");
			}

		} else {
			resp.sendRedirect(req.getContextPath() + "/login-admin");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
