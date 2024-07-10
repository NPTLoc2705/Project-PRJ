/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.servlet;

import com.books.BookDAO;
import com.books.BookDTO;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GIGABYTE
 */
public class BookController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            BookDAO dao = new BookDAO();
            String keyword = request.getParameter("keyword");
            if (action == null || action.equals("list") || action.equals("login")) {

                if (keyword == null) {
                    keyword = "";
                }
                System.out.println(getServletContext().getRealPath("img"));

                List<BookDTO> list = dao.list(keyword);
                request.setAttribute("booklist", list);
                request.getRequestDispatcher("index.jsp").forward(request, response);

            } else if (action.equals("download")) {
                int id = Integer.parseInt(request.getParameter("id"));
                BookDTO book = dao.FileDownloader(id);

                response.setContentType("APPLICATION/OCTET-STREAM");
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment; filename=" + book.getTitle());

                FileInputStream input = new FileInputStream(book.getDownloadLink());
                int i;
                while ((i = input.read()) != -1) {
                    out.write(i);
                }
                input.close();
                out.close();
            } else if (action.equals("delete")) {
                Integer id = null;
                try {
                    id = Integer.parseInt(request.getParameter("bookid"));
                } catch (NumberFormatException e) {
                    log("Parameter id has wrong format");
                }
                dao.delete(id);
                response.sendRedirect("BookController");
            }
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
