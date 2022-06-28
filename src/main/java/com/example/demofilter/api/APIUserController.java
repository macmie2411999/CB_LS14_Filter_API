package com.example.demofilter.api;

import com.example.demofilter.model.UsersModel;
import com.example.demofilter.pojo.Users;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/api/users")
public class APIUserController extends HttpServlet {
    UsersModel usersModel = new UsersModel();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        usersModel.getListUsers();
        List<Users> listUsers = usersModel.getListUsers();
        Gson gson = new Gson();
        String json = gson.toJson(listUsers);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        writer.write(json);
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
