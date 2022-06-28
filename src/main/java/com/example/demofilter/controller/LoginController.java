package com.example.demofilter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demofilter.common.Constant;
import com.example.demofilter.model.UsersModel;
import com.example.demofilter.pojo.Users;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	
	UsersModel usersModel = new UsersModel();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Users user = usersModel.getUsers(email, password);
		
		if(user != null) {
			Cookie cookie = new Cookie(Constant.COOKIES_USER, user.getFullname());
			cookie.setMaxAge(600);
			resp.addCookie(cookie);
			
			resp.sendRedirect(req.getContextPath() + "/admin");
		}else {
			System.out.println("Đăng nhập thất bại");
		}
		
	}
	
}
