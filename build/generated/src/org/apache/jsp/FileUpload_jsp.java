package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class FileUpload_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <meta charset=\"utf-8\" />\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\r\n");
      out.write("        <link\r\n");
      out.write("            rel=\"stylesheet\"\r\n");
      out.write("            href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,400\"\r\n");
      out.write("            />\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/bootstrap.min.css\" />\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/templatemo-style.css\" />\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/Upload.css\"/>\r\n");
      out.write("        <title>File Upload</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <<div class=\"tm-header\">\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("                <div class=\"tm-header-inner\">\r\n");
      out.write("                    <div class=\"tm-header-logo\">\r\n");
      out.write("                        <a href=\"#\" class=\"navbar-brand tm-site-name\"\r\n");
      out.write("                           ><img src=\"img/hinh.png\" alt=\"\"\r\n");
      out.write("                              /></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <!-- navbar -->\r\n");
      out.write("                    <nav class=\"navbar tm-main-nav\">\r\n");
      out.write("                        <button\r\n");
      out.write("                            class=\"navbar-toggler hidden-md-up\"\r\n");
      out.write("                            type=\"button\"\r\n");
      out.write("                            data-toggle=\"collapse\"\r\n");
      out.write("                            data-target=\"#tmNavbar\"\r\n");
      out.write("                            >\r\n");
      out.write("                            &#9776;\r\n");
      out.write("                        </button>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"collapse navbar-toggleable-sm\" id=\"tmNavbar\">\r\n");
      out.write("                            <ul class=\"nav navbar-nav\">\r\n");
      out.write("                                <div class =\"search-box\">\r\n");
      out.write("                                    <input class=\"search-box-input\" type=\"text\">\r\n");
      out.write("                                    <button class=\"search-box-bth\" type=\"submit\"><ion-icon name=\"search-outline\"></ion-icon></button>\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <li class=\"nav-item active\">\r\n");
      out.write("                                    <a href=\"index.html\" class=\"nav-link\">Home</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li class=\"nav-item\">\r\n");
      out.write("                                    <a href=\"about.html\" class=\"nav-link\">About</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li class=\"nav-item\">\r\n");
      out.write("                                    <a href=\"Login.jsp\" class=\"nav-link\">Sign up</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </nav>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"upload-box\">\r\n");
      out.write("                <div class=\"upload-icon\">\r\n");
      out.write("                    <i class=\"fas fa-upload\"></i>\r\n");
      out.write("                </div>\r\n");
      out.write("                <h2>Upload your book</h2>\r\n");
      out.write("                <form>\r\n");
      out.write("                    <div class=\"input-group\">\r\n");
      out.write("                        <label for=\"file-upload\" class=\"file-label\">Choose file</label>\r\n");
      out.write("                        <input type=\"file\" id=\"file-upload\" class=\"file-input\">\r\n");
      out.write("                        <span>No file chosen</span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"input-group\">\r\n");
      out.write("                        <label for=\"cover-upload\" class=\"file-label\">Choose file</label>\r\n");
      out.write("                        <input type=\"file\" id=\"cover-upload\" class=\"file-input\">\r\n");
      out.write("                        <input type=\"text\" placeholder=\"Book cover\" class=\"text-input\">\r\n");
      out.write("                    </div>\r\n");
      out.write("<div class=\"input-group\">\r\n");
      out.write("    <label for=\"genres\">Choose a book genre(s):</label><br>\r\n");
      out.write("    <input type=\"checkbox\" id=\"horror\" name=\"genres\" value=\"Horror\">\r\n");
      out.write("    <label for=\"horror\">Horror</label><br>\r\n");
      out.write("    <input type=\"checkbox\" id=\"sex-content\" name=\"genres\" value=\"Sex-Content\">\r\n");
      out.write("    <label for=\"sex-content\">Sexual Content</label><br>\r\n");
      out.write("    <input type=\"checkbox\" id=\"romance\" name=\"genres\" value=\"Romance\">\r\n");
      out.write("    <label for=\"romance\">Romance</label><br>\r\n");
      out.write("    <input type=\"checkbox\" id=\"dark-fantasy\" name=\"genres\" value=\"Dark-Fantasy\">\r\n");
      out.write("    <label for=\"dark-fantasy\">Dark Fantasy</label><br>\r\n");
      out.write("</div>\r\n");
      out.write("                    <div class=\"text-fields\">\r\n");
      out.write("                        <input type=\"text\" placeholder=\"Author\" class=\"text-input\">\r\n");
      out.write("                        <input type=\"text\" placeholder=\"Book name\" class=\"text-input\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"description-field\">\r\n");
      out.write("                        <textarea placeholder=\"Description\" class=\"textarea-input\"></textarea>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <button type=\"submit\" class=\"upload-button\">Upload</button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
