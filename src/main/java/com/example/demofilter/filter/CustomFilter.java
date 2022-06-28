package com.example.demofilter.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demofilter.common.Constant;

@WebFilter("/login")
public class CustomFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
//
//		String contextPath = req.getContextPath();
//		String servletPath = req.getServletPath();
//
//		if(servletPath.contains("/login")) {
//			resp.sendRedirect( contextPath + "/register");
//		}else {
//			chain.doFilter(request, response);
//		}
		
		
		
//		resp.sendRedirect(null);
		
		
		Cookie[] cookies = req.getCookies();
		boolean isExistUser = false;
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals(Constant.COOKIES_USER)) {
				isExistUser = true;
			}
		}
		
		if(isExistUser) {
			resp.sendRedirect(req.getContextPath() + "/admin");
		}else {
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
