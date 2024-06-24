package com.login.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.User.UserDAO;
import com.User.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tab135
 */
@WebServlet(urlPatterns = {"/Accounts"})
public class AccountsLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String auth_name = request.getParameter("user");
        String auth_password = request.getParameter("pass");
        System.out.println();
        if(action.equals("login")){
               UserDAO dao = new UserDAO();
        UserDTO user = dao.login(auth_name, auth_password);
        if (user != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("loginSession", user);
                RequestDispatcher rd = request.getRequestDispatcher("BookController");
                rd.forward(request, response);
        } else {
            request.setAttribute("error", "Username or password is incorrect");
            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);
        }
        
        }
        if(action.equals("signup")){
                String auth_email = request.getParameter("email");
        UserDAO dao = new UserDAO();
        UserDTO user = dao.signup(auth_email, auth_name, auth_password);
        if(user != null){
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
        }else{
            request.setAttribute("error", "User name or email already exist, please sign up again");
            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);
        }
        }
        
        if(action.equals("signout")){
            HttpSession session = request.getSession(false);
            request.getSession().invalidate();
            response.sendRedirect("Login");
        }
     

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
