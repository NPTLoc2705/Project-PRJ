package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.User.UserDTO;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/nav.jsp");
  }

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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\" />\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n");
      out.write("\r\n");
      out.write("        <title>Classic - Responsive Bootstrap 4.0 Template</title>\r\n");
      out.write("\r\n");
      out.write("        <link\r\n");
      out.write("            rel=\"stylesheet\"\r\n");
      out.write("            href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,400\"\r\n");
      out.write("            />\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/bootstrap.min.css\" />\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/templatemo-style.css\" />\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("<div class=\"tm-header\">\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("                <div class=\"tm-header-inner\">\r\n");
      out.write("                    <div class=\"tm-header-logo\">\r\n");
      out.write("                        <a href=\"BookController\" class=\"navbar-brand tm-site-name\"\r\n");
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
      out.write("                                    <form action=\"BookController\" method=\"GET\">\r\n");
      out.write("                                        <input class=\"search-box-input\" type=\"text\" name=\"keyword\" value=\"");
      out.print(request.getParameter("keyword") != null ? request.getParameter("keyword") : "");
      out.write("\">\r\n");
      out.write("                                        <button class=\"search-box-bth\" type=\"submit\" value=\"search\"><ion-icon name=\"search-outline\"></ion-icon></button>\r\n");
      out.write("                                    </form>\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <li class=\"nav-item \">\r\n");
      out.write("                                    <a href=\"index.jsp\" class=\"nav-link\">Home</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li class=\"nav-item\">\r\n");
      out.write("                                    <a href=\"FileUpload.jsp\" class=\"nav-link\">Upload</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                ");
 UserDTO user = (UserDTO) request.getAttribute("session");
                                    if (user != null) {
                                
      out.write("\r\n");
      out.write("                                <li class=\"nav-item\">\r\n");
      out.write("                                    <a href=\"Login.jsp\" class=\"nav-link\">Sign out</a>\r\n");
      out.write("                                    ");
 } else {
      out.write("\r\n");
      out.write("                                <li class=\"nav-item\">\r\n");
      out.write("                                    <a href=\"Login.jsp\" class=\"nav-link\">Sign up</a>\r\n");
      out.write("                                    ");
 }
      out.write("\r\n");
      out.write("                                </li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </nav>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container\" id=\"container\">\r\n");
      out.write("            <div class=\"form-container sign-up\">\r\n");
      out.write("                <form action=\"./SignUp\" method = \"Post\">\r\n");
      out.write("                    <h1>Create Account</h1>\r\n");
      out.write("                    <span>or use your email for registeration</span>\r\n");
      out.write("                    <input type=\"text\" placeholder=\"Name\" name=\"user\" />\r\n");
      out.write("                    <input type=\"email\" placeholder=\"Email\" name=\"email\" />\r\n");
      out.write("                    <input type=\"password\" placeholder=\"Ex:123\" name=\"pass\" />\r\n");
      out.write("                    <button>Sign Up</button>\r\n");
      out.write("\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-container sign-in\">\r\n");
      out.write("                <form action=\"./Login?action=login\" method=\"post\">\r\n");
      out.write("                    <h1>Sign In</h1>\r\n");
      out.write("                    <span>or use your email password</span>\r\n");
      out.write("                    <input type=\"text\" placeholder=\"Email or User Name\" name=\"user\" />\r\n");
      out.write("                    <input type=\"password\" placeholder=\"Ex:123\" name=\"pass\" />\r\n");
      out.write("                    <a href=\"#\">Forget Your Password?</a>\r\n");
      out.write("                    <style>\r\n");
      out.write("                        h3{\r\n");
      out.write("                            color:red;\r\n");
      out.write("                            font-size:80%;\r\n");
      out.write("                        }\r\n");
      out.write("                        \r\n");
      out.write("                    </style>\r\n");
      out.write("                    ");
 String error = (String) request.getAttribute("error"); 
      out.write("\r\n");
      out.write("                    ");
 if (error != null) {
      out.write("\r\n");
      out.write("                   \r\n");
      out.write("                        <h3 color=\"red\"> ");
      out.print( error);
      out.write(" </h3>\r\n");
      out.write("                    \r\n");
      out.write("                    ");
 }
      out.write("\r\n");
      out.write("                    <button>Sign In</button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"toggle-container\">\r\n");
      out.write("                <div class=\"toggle\">\r\n");
      out.write("                    <div class=\"toggle-panel toggle-left\">\r\n");
      out.write("                        <h1>Hello, Friend!</h1>\r\n");
      out.write("                        <p>\r\n");
      out.write("                            You must be new here,please use your personal details to use all\r\n");
      out.write("                            of sites features\r\n");
      out.write("                        </p>\r\n");
      out.write("                        <button class=\"hidden\" id=\"login\">Sign In</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"toggle-panel toggle-right\">\r\n");
      out.write("                        <h1>Welcome Back!</h1>\r\n");
      out.write("                        <p>Enter your personal details to use all of site features</p>\r\n");
      out.write("                        <button class=\"hidden\" id=\"register\">Sign Up</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <script src=\"js/login.js\"></script>\r\n");
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
