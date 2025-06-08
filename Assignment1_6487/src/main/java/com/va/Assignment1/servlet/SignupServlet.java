package com.va.Assignment1.servlet;

import java.io.IOException;

import com.va.Assignment1.dao.sDao;
import com.va.Assignment1.model.Signup;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SignupServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");
        String preferredName = request.getParameter("preferredName");
        String name = request.getParameter("name");

        Signup su = new Signup();
        su.setUserName(userName);
        su.setUserEmail(userEmail);
        su.setPassword(password);
        su.setPassword1(password1);
        su.setPreferredName(preferredName);
        su.setName(name);

        try {
            sDao dao = new sDao();
            int result = dao.registerUser(su);
            
            if (result > 0) {
                response.sendRedirect("index.jsp");
            } else {
                response.getWriter().println("Error registering user. Please try again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Server Error: " + e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
}
