package controller;

import dao.studentservice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class logincontroller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       String email=req.getParameter("email");
       String password=req.getParameter("password");
       studentservice sts=new studentservice();
       try{
           if(sts.login(email,password)){
               resp.sendRedirect("homepage.html");
           }else {
               resp.getWriter().println("Incorrect Email or password");
           }
       }catch(SQLException e)
       {
       throw new ServletException(e);
       }
    }
}
