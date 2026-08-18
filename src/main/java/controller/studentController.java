package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.studentservice;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class studentController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);

        String name = req.getParameter("username");
        System.out.println(name);

        String email = req.getParameter("email");
        System.out.println(email);

        // Convert String from HTML form to int
        int redg = Integer.parseInt(req.getParameter("redgno"));
        System.out.println(redg);

        studentservice sts = new studentservice();


        try {
            if (sts.register(id, name, email, redg)) {
                resp.sendRedirect("login.html");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        }