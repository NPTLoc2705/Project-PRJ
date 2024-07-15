/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.servlet;

import com.books.BookDAO;
import com.books.BookDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
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
            
            String action = request.getParameter("action");
            BookDAO dao = new BookDAO();
            if (action == null || action.equals("list") || action.equals("login")) {
                String keyword = request.getParameter("keyword");
                int pageId = 0;
                String SpageId = request.getParameter("page");
                if(SpageId !=null){
                    pageId = Integer.parseInt(SpageId) * 6;
                }
                
                if (keyword == null) {
                    keyword = "";
                }
                List<BookDTO> list = dao.list(keyword,pageId,1); // cái khúc này là để lấy 6 cuốn sách trong một trang 
                
                int page_counter = (int)Math.ceil((double)dao.list(keyword,pageId,0).size() /6); // cái khúc này để lấy tổng số sách để chia trang
                request.setAttribute("booklist", list);
                request.setAttribute("counter", page_counter);
                request.getRequestDispatcher("index.jsp").forward(request, response);

            } else if (action.equals("download")) {
                        int id = Integer.parseInt(request.getParameter("id"));
                        BookDTO book = dao.FileDownloader(id);
                        response.setHeader("Content-Disposition", "attachment; filename=" + book.getTitle());

                        File file = new File(book.getDownloadLink());
                        response.setHeader("Content-Length", String.valueOf(file.length()));

                        try (FileInputStream input = new FileInputStream(file);
                             OutputStream output = response.getOutputStream()) {

                          byte[] buffer = new byte[1024];
                          int bytes;
                          while ((bytes = input.read(buffer)) != -1) {
                            output.write(buffer, 0, bytes);
                          }
                        } catch (IOException e) {
                          e.printStackTrace();
                        }
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
            
            else if(action.equals("cover")){
                response.setContentType("text/html;charset=UTF-8");
                String filename = request.getParameter("filename");
                String filePath = "D:\\PUBLIC_DB\\Image/" + filename;

                File file = new File(filePath);

                if (file.exists()) {

                  try (FileInputStream inputStream = new FileInputStream(file)) {
                    byte[] data = new byte[(int) file.length()];
                    inputStream.read(data);


                    response.getOutputStream().write(data);
                  }
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
