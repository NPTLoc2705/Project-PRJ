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
public class AccountsController extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String auth_name = request.getParameter("user");
        String auth_password = request.getParameter("pass");
        System.out.println(action);
        switch (action) {
            case "login": {
                UserDAO dao = new UserDAO();
                UserDTO user = dao.login(auth_name, auth_password);
                if (user != null) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("loginSession", user);
                    response.sendRedirect("BookController?pageid=0");

                } else {
                    request.setAttribute("error", "Username or password is incorrect");
                    RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                    rd.forward(request, response);
                }
                break;
            }
            case "signup": {
                String auth_email = request.getParameter("email");
                UserDAO dao = new UserDAO();
                UserDTO user = dao.signup(auth_email, auth_name, auth_password);
                if (user != null) {
                    request.setAttribute("error", "Sign Up successfully");
                    RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                    rd.forward(request, response);
                } else {
                    request.setAttribute("error", "User name or email already exist, please sign up again");
                    RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                    rd.forward(request, response);
                }
                break;
            }
            case "signout": {
                HttpSession session = request.getSession(false);
                request.getSession().invalidate();
                response.sendRedirect("Login.jsp");
                break;
            }
            case "detail": {
                Integer id = null;
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                } catch (NumberFormatException e) {
                    log("Parameter has wrong format");
                }
                System.out.println(id);
                UserDAO dao = new UserDAO();
                UserDTO ud = null;
                if (id != null) {
                    ud = dao.load(id);
                }
                request.setAttribute("user", ud);
                RequestDispatcher rd = request.getRequestDispatcher("User.jsp");
                rd.forward(request, response);
                break;
            }
            case "edit": {
                Integer id = null;
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                } catch (NumberFormatException e) {
                    log("Parameter id has wrong format");
                }
                UserDAO dao = new UserDAO();
                UserDTO user = null;
                if (id != null) {
                    user = dao.load(id);
                }
                request.setAttribute("user", user);
                RequestDispatcher rd = request.getRequestDispatcher("EditUser.jsp");
                rd.forward(request, response);
                break;
            }
            case "update": {
                Integer id = null;
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                } catch (NumberFormatException e) {
                    log("Parameter id has wrong format");
                }
                String account = request.getParameter("full_name");
                String email = request.getParameter("email_address");
                String pass = request.getParameter("new_password");
                UserDAO dao = new UserDAO();
                UserDTO user = null;
                if (id != null) {
                    user = dao.load(id);
                }
                user.setUsername(account);
                user.setEmail(email);
                user.setPassword(pass);
                dao.update(user);
                request.setAttribute("user", user);
                HttpSession session = request.getSession(true);
                session.setAttribute("loginSession", user);
                response.sendRedirect("Login?action=detail&id=" + id);
                break;
            }
            default:
                break;
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
