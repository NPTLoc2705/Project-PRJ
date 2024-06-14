/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileUpload;

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             String extension = "";
             String Booknames="";
              Part part = request.getPart("file");
              String original_name = part.getSubmittedFileName();
             
              int dot_index = original_name.lastIndexOf('.');
              if (dot_index > 0 && dot_index < original_name.length() - 1) {
            extension = original_name.substring(dot_index + 1);
        }
              
if ("pdf".equals(extension) || "epub".equals(extension)) {
            String Bookname = request.getParameter("bookname");
            if (Bookname != null && !Bookname.trim().isEmpty()) {
                    Booknames = Bookname + "." + extension;
            } else {
                out.println("Need book name");
            }
        } else {
         out.println( "Only PDF and EPUB files are allowed.");
        }
              
              
              String path = "D:\\PUBLIC_DB\\" + Booknames ; // Nên để database qua ổ D, đừng bỏ vào folder của project luôn, nó nặng lúc sync github
             
              InputStream input = part.getInputStream();
              
///Check succes upload
             boolean success = FileUploader(input, path);
             if (success){
                 out.println("Done: " + path);
             }
             else{
                 response.sendRedirect("./FileUpload.jsp");
             }
        }
    }
    
    
    
public boolean FileUploader(InputStream input, String path) {
    boolean Success = false;
    try {
        byte[] bytes = new byte[input.available()];
        
//Đọc byte và ghi xuống path
        int bytesRead = input.read(bytes); 
        if (bytesRead > 0) {
            FileOutputStream outputBook = new FileOutputStream(path);
            outputBook.write(bytes, 0, bytesRead); 
            outputBook.flush();
            outputBook.close();
            Success= true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return Success;
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
