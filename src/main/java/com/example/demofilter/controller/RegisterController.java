package com.example.demofilter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demofilter.common.Constant;
import com.example.demofilter.model.UsersModel;
import com.example.demofilter.pojo.Users;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	
	UsersModel usersModel = new UsersModel();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.getRequestDispatcher("register.jsp").forward(req, resp);
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		Users users = new Users();
//		users.setFullname(req.getParameter("fullname"));
//		users.setEmail(req.getParameter("email"));
//		users.setPassword(req.getParameter("password"));
//		users.setRole_id(Constant.ROLE_USER);
//		
//		boolean isSuccess = usersModel.insertUsers(users);
//		
//		if(isSuccess) {
//			System.out.println("Success");
//		}else {
//			System.out.println("Fail");
//		}
//		
//	}
	
}
