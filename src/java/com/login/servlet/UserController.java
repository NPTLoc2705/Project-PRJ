/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.servlet;

import com.User.UserDAO;
import com.User.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GIGABYTE
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

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
        UserDAO dao = new UserDAO();
        if (action == null || action.equals("list")) {
            List<UserDTO> list = dao.getAllUsers();
            request.setAttribute("userlist", list);

            request.getRequestDispatcher("/User.jsp").forward(request, response);
        } else if (action.equals("detail")) {
            Integer id = null;
            try {
                id = Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException e) {
                log("Parameter has wrong format");
            }
            System.out.println(id);
            UserDTO ud = null;
            if (id != null) {
                ud = dao.load(id);
            }
            request.setAttribute("user", ud);
            RequestDispatcher rd = request.getRequestDispatcher("User.jsp");
            rd.forward(request, response);

        } else if (action.equals("edit")) {
            Integer id = null;
            try {
                id = Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException e) {
                log("Parameter id has wrong format");
            }
            UserDTO user = null;
            if (id != null) {
                user = dao.load(id);
            }
            HttpSession session = request.getSession(true);
            session.setAttribute("loginSession",user );           
            request.setAttribute("user", user);
            RequestDispatcher rd = request.getRequestDispatcher("EditUser.jsp");
            rd.forward(request, response);
        }
        
        else if(action.equals("update"))
        {
            Integer id = null;
            try{
                id = Integer.parseInt(request.getParameter("id"));
            }catch(NumberFormatException e)
            {
                log("Parameter id has wrong format");
            }
            String account = request.getParameter("full_name");
            String email = request.getParameter("email_address");
            String pass = request.getParameter("new_password");
            UserDTO user = null;
            if(id != null)
            {
                user = dao.load(id);
            }
            user.setUsername(account);
            user.setEmail(email);
            user.setPassword(pass);
            dao.update(user);
            request.setAttribute("user", user);
            response.sendRedirect("UserController?action=detail&id=" + id); ;
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
