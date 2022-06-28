package com.example.demofilter.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demofilter.common.Constant;
import com.example.demofilter.model.UsersModel;
import com.example.demofilter.pojo.ResponseData;
import com.example.demofilter.pojo.Users;
import com.google.gson.Gson;

@WebServlet("/api/register")
public class APIRegisterController extends HttpServlet {
	
	UsersModel usersModel = new UsersModel();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Users users = new Users();
		users.setFullname(req.getParameter("fullname"));
		users.setEmail(req.getParameter("email"));
		users.setPassword(req.getParameter("password"));
		users.setRole_id(Constant.ROLE_USER);
		
		boolean isSuccess = usersModel.insertUsers(users);
		
		ResponseData responseData = new ResponseData();
		responseData.setSuccess(isSuccess);
		
		if(isSuccess) {
			responseData.setMessage("Success");
		}else {
			responseData.setMessage("Failed");
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(responseData);

		// format and set type
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.write(json);
		writer.flush();
		writer.close();
	}
	
	/* 
	 * B1: Tạo một API trả ra danh sách User
	 * B2: Ajax gọi API lấy danh sách user
	 * B3: Lấy dữ liệu gọi từ api append table
	 * */
	
}
