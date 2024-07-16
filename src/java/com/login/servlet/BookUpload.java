/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.servlet;

import com.User.UserDAO;
import com.User.UserDTO;
import com.books.BookDAO;
import com.books.BookDTO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Tab135
 */
@WebServlet(name = "BookUpload", urlPatterns = {"/BookUpload"})
@MultipartConfig //This form is sumited multiple data "FILE"
public class BookUpload extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String extension = "";
            String extension_image="";
             String Booknames="";
            String author = request.getParameter("author");
            String description = request.getParameter("description");
            int UserID = Integer.parseInt(request.getParameter("userID"));
              Part part = request.getPart("file");
              String original_name = part.getSubmittedFileName(); //book
              InputStream input_file = part.getInputStream();
                Part cover = request.getPart("cover-image"); //image
              String cover_name = cover.getSubmittedFileName();
              InputStream input_cover= cover.getInputStream();
              String[] categories = request.getParameterValues("categories");
              int dot_index = original_name.lastIndexOf('.');
              if (dot_index > 0 && dot_index < original_name.length() - 1) {
            extension = original_name.substring(dot_index + 1);
        }
            int dot_index_image = cover_name.lastIndexOf('.');
              if (dot_index_image > 0 && dot_index_image < cover_name.length() - 1) {
            extension_image = cover_name.substring(dot_index_image + 1);
        }      
if ("pdf".equals(extension) || "epub".equals(extension)) {
            String Bookname = request.getParameter("bookname");
            if (Bookname != null && !Bookname.trim().isEmpty()) {
                    Booknames = Bookname + "." + extension;
            } else {
                request.setAttribute("error","Need book name" );
            }
        } else {
            request.setAttribute("error","Only PDF and EPUB files are allowed." );
        }
if(!extension_image.equals("jpg") && !extension_image.equals("png")){
            request.setAttribute("error","Only PNG and JPG files are allowed for cover image" );
             request.getRequestDispatcher("./FileUpload.jsp").forward(request, response);
             return;
        }
        String image_path = "D:\\PUBLIC_DB\\Image\\" + cover_name;
          UserDAO userDao = new UserDAO();
        int ban = userDao.checkBan(UserID);
        if(ban == 0){
                        BookDAO dao = new BookDAO();
            BookDTO book = dao.FileUploader(Booknames,author,description,cover_name,UserID);
            dao.saveBookCategories(book.getBookID(),categories);
        File imageFile = new File(image_path);
            try (FileOutputStream outputImage = new FileOutputStream(imageFile)) {
                byte[] buffer = new byte[1024];
                int bytes;
                while ((bytes = input_cover.read(buffer)) != -1) {
                    outputImage.write(buffer, 0, bytes);
                }
            }
        String path = "D:\\PUBLIC_DB\\Books\\" + Booknames;
            File bookFile = new File(path);
            try (FileOutputStream outputBook = new FileOutputStream(bookFile)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = input_file.read(buffer)) != -1) {
                    outputBook.write(buffer, 0, bytesRead);
                }
            }
            if (book != null && ban == 0){
                 request.setAttribute("success","Book submited successfuly" );
                 request.getRequestDispatcher("./FileUpload.jsp").forward(request, response);
             }
        }
            if(ban != 0){
                request.setAttribute("error","You are not permitted to upload book, please contact admin" );
            }

                 request.getRequestDispatcher("./FileUpload.jsp").forward(request, response);
             
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


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
