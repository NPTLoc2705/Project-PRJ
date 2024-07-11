package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.books.BookDTO;
import com.User.UserDTO;
import com.User.UserDTO;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/nav.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_end_begin;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_var_end_begin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_forEach_var_end_begin.release();
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\" />\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n");
      out.write("\r\n");
      out.write("        <title>Stolen Books</title>\r\n");
      out.write("\r\n");
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
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
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
      out.write("                                    <a href=\"BookController\" class=\"nav-link\">Home</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                            ");
 HttpSession sessions = request.getSession(false);
                                    if (sessions.getAttribute("loginSession") != null) {
                                
      out.write("\r\n");
      out.write("                                \r\n");
      out.write("                                <li class=\"nav-item\">\r\n");
      out.write("                                    <a href=\"FileUpload.jsp\" class=\"nav-link\">Upload</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li class=\"nav-item\">\r\n");
      out.write("                                    <a href=\"Login?action=signout\" class=\"nav-link\">Sign out</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                    ");
 } else {
      out.write("\r\n");
      out.write("                                <li class=\"nav-item\">\r\n");
      out.write("                                    <a href=\"Login.jsp\" class=\"nav-link\">Upload</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li class=\"nav-item\">\r\n");
      out.write("                                    <a href=\"Login.jsp\" class=\"nav-link\">Sign up</a>\r\n");
      out.write("                                     </li>\r\n");
      out.write("                                    ");
 }
      out.write("\r\n");
      out.write("                               \r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </nav>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>");
      out.write("\r\n");
      out.write("        <div class=\"tm-home-img-container\">\r\n");
      out.write("            <img\r\n");
      out.write("                src=\"img/1_6Jp3vJWe7VFlFHZ9WhSJng.jpg\"\r\n");
      out.write("                alt=\"Image\"\r\n");
      out.write("                class=\"hidden-lg-up img-fluid\"\r\n");
      out.write("                />\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <section class=\"tm-section\">\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12 text-xs-center\">\r\n");
      out.write("                        <h2 class=\"tm-gold-text tm-title\">Introduction</h2>\r\n");
      out.write("                        <p class=\"tm-subtitle\">\r\n");
      out.write("                            Suspendisse ut magna vel velit cursus tempor ut nec nunc. Mauris\r\n");
      out.write("                            vehicula, augue in tincidunt porta, purus ipsum blandit massa.\r\n");
      out.write("                        </p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                \r\n");
      out.write("                <table>\r\n");
      out.write("                    ");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                    ");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_0.setPageContext(_jspx_page_context);
      _jspx_th_c_if_0.setParent(null);
      _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty booklist}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
      if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                        ");
          //  c:forEach
          org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
          _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
          _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
          _jspx_th_c_forEach_0.setVar("book");
          _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${booklist}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
          int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
          try {
            int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
            if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              do {
                out.write("\r\n");
                out.write("                            <div class=\"book\">\r\n");
                out.write("                                <img\r\n");
                out.write("                                    src=\"testy?filename=");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.cover}", java.lang.String.class, (PageContext)_jspx_page_context, null));
                out.write("\"\r\n");
                out.write("                                    alt=\"Living in the Light\"\r\n");
                out.write("                                    />\r\n");
                out.write("                                <div class=\"book-details\">\r\n");
                out.write("                                    <p class=\"book-title\">\r\n");
                out.write("                                        ");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
                out.write("\r\n");
                out.write("                                    </p>\r\n");
                out.write("                                    <p class=\"book-meta\">");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.description}", java.lang.String.class, (PageContext)_jspx_page_context, null));
                out.write("</p>\r\n");
                out.write("                                    <div class=\"book-actions\">\r\n");
                out.write("                                        <button>Download</button>\r\n");
                out.write("                                        ");

                                            UserDTO user = (UserDTO) sessions.getAttribute("loginSession");
                                            if (user != null) {
                                                if (user.getUsername().equals("Tab135")) {
                                        
                out.write("\r\n");
                out.write("                                        <form action=\"BookController\">\r\n");
                out.write("                                        <button>Delete</button>\r\n");
                out.write("                                        <input name=\"action\" value=\"delete\" type=\"hidden\">\r\n");
                out.write("                                        <input name=\"bookid\" value=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.bookID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
                out.write("\" type=\"hidden\">\r\n");
                out.write("                                        </form>\r\n");
                out.write("                                        ");
}
                out.write("\r\n");
                out.write("                                        ");
}
                out.write("\r\n");
                out.write("\r\n");
                out.write("                                        <form action=\"Bookdetail\">\r\n");
                out.write("                                            <button class=\"like-button\">Detail</button>\r\n");
                out.write("                                            <input name=\"action\" value=\"detail\" type=\"hidden\">\r\n");
                out.write("                                            <input name=\"bookid\" value=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.bookID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
                out.write("\" type=\"hidden\">\r\n");
                out.write("                                        </form>\r\n");
                out.write("                                    </div>\r\n");
                out.write("                                </div>\r\n");
                out.write("                            </div>\r\n");
                out.write("                        ");
                int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
            }
            if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              return;
            }
          } catch (Throwable _jspx_exception) {
            while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
              out = _jspx_page_context.popBody();
            _jspx_th_c_forEach_0.doCatch(_jspx_exception);
          } finally {
            _jspx_th_c_forEach_0.doFinally();
            _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
          }
          out.write("\r\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      out.write("\r\n");
      out.write("                    ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                </table>\r\n");
      out.write("                    ");

                        String spageid = request.getParameter("page");
                    int pageid = 0;
                        if(spageid != null) {
                            pageid = Integer.parseInt(spageid);
                        }
                        
      out.write("\r\n");
      out.write("                        ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        </section>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <footer class=\"tm-footer\">\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3\">\r\n");
      out.write("                        <div class=\"tm-footer-content-box\">\r\n");
      out.write("                            <h3 class=\"tm-gold-text tm-title tm-footer-content-box-title\">\r\n");
      out.write("                                Proin eu posuere felis\r\n");
      out.write("                            </h3>\r\n");
      out.write("                            <div class=\"tm-gray-bg\">\r\n");
      out.write("                                <img\r\n");
      out.write("                                    src=\"img/434253443_970851104438224_6556823117598086585_n.jpg\"\r\n");
      out.write("                                    alt=\"\"\r\n");
      out.write("                                    />\r\n");
      out.write("                                <p>Chá»§ khÃ¡ch sáº¡n vÃ  sá»© giáº£ káº¿t thÃ¢n báº¡n tÃ¬nh</p>\r\n");
      out.write("                                <p><strong>Danny Egg (Executive)</strong></p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3\">\r\n");
      out.write("                        <div class=\"tm-footer-content-box tm-footer-links-container\">\r\n");
      out.write("                            <h3 class=\"tm-gold-text tm-title tm-footer-content-box-title\">\r\n");
      out.write("                                Nulla tortor dolor\r\n");
      out.write("                            </h3>\r\n");
      out.write("                            <nav>\r\n");
      out.write("                                <ul class=\"nav\">\r\n");
      out.write("                                    <li>\r\n");
      out.write("                                        <a href=\"#\" class=\"tm-footer-link\"\r\n");
      out.write("                                           >Tincidunt non faucibus</a\r\n");
      out.write("                                        >\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                    <li>\r\n");
      out.write("                                        <a href=\"#\" class=\"tm-footer-link\">Vestibulum tempor</a>\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                    <li>\r\n");
      out.write("                                        <a href=\"#\" class=\"tm-footer-link\"\r\n");
      out.write("                                           >Fusce non turpis euismod</a\r\n");
      out.write("                                        >\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                    <li>\r\n");
      out.write("                                        <a href=\"#\" class=\"tm-footer-link\">Lorem ipsum dolor sit</a>\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                    <li>\r\n");
      out.write("                                        <a href=\"#\" class=\"tm-footer-link\"\r\n");
      out.write("                                           >Nam in augue consectetur</a\r\n");
      out.write("                                        >\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                    <li>\r\n");
      out.write("                                        <a href=\"#\" class=\"tm-footer-link\"\r\n");
      out.write("                                           >Text Link Color #CCCC66</a\r\n");
      out.write("                                        >\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </nav>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <!-- Add the extra clearfix for only the required viewport \r\n");
      out.write("                                  http://stackoverflow.com/questions/24590222/bootstrap-3-grid-with-different-height-in-each-item-is-it-solvable-using-only\r\n");
      out.write("                    -->\r\n");
      out.write("                    <div class=\"clearfix hidden-lg-up\"></div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3\">\r\n");
      out.write("                        <div class=\"tm-footer-content-box\">\r\n");
      out.write("                            <h3 class=\"tm-gold-text tm-title tm-footer-content-box-title\">\r\n");
      out.write("                                Etiam mollis ornare\r\n");
      out.write("                            </h3>\r\n");
      out.write("                            <p class=\"tm-margin-b-30\">\r\n");
      out.write("                                Aenean cursus tellus mauris, quis consequat mauris dapibus id.\r\n");
      out.write("                                Donec scelerisque porttitor pharetra.\r\n");
      out.write("                            </p>\r\n");
      out.write("                            <hr class=\"tm-margin-b-30\" />\r\n");
      out.write("                            <p class=\"tm-margin-b-30\">\r\n");
      out.write("                                Aenean cursus tellus mauris, quis consequat mauris dapibus id.\r\n");
      out.write("                                Donec scelerisque porttitor pharetra.\r\n");
      out.write("                            </p>\r\n");
      out.write("                            <hr class=\"tm-margin-b-30\" />\r\n");
      out.write("                            <p class=\"tm-margin-b-30\">\r\n");
      out.write("                                Aenean cursus tellus mauris, quis consequat mauris dapibus id.\r\n");
      out.write("                                Donec scelerisque porttitor pharetra.\r\n");
      out.write("                            </p>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3\">\r\n");
      out.write("                        <div class=\"tm-footer-content-box\">\r\n");
      out.write("                            <h3 class=\"tm-gold-text tm-title tm-footer-content-box-title\">\r\n");
      out.write("                                Fusce non turpis\r\n");
      out.write("                            </h3>\r\n");
      out.write("                            <div class=\"tm-margin-b-30\">\r\n");
      out.write("                                <img\r\n");
      out.write("                                    src=\"img/tm-img-100x100-1.jpg\"\r\n");
      out.write("                                    alt=\"Image\"\r\n");
      out.write("                                    class=\"tm-footer-thumbnail\"\r\n");
      out.write("                                    />\r\n");
      out.write("                                <img\r\n");
      out.write("                                    src=\"img/tm-img-100x100-2.jpg\"\r\n");
      out.write("                                    alt=\"Image\"\r\n");
      out.write("                                    class=\"tm-footer-thumbnail\"\r\n");
      out.write("                                    />\r\n");
      out.write("                                <img\r\n");
      out.write("                                    src=\"img/tm-img-100x100-3.jpg\"\r\n");
      out.write("                                    alt=\"Image\"\r\n");
      out.write("                                    class=\"tm-footer-thumbnail\"\r\n");
      out.write("                                    />\r\n");
      out.write("                                <img\r\n");
      out.write("                                    src=\"img/tm-img-100x100-4.jpg\"\r\n");
      out.write("                                    alt=\"Image\"\r\n");
      out.write("                                    class=\"tm-footer-thumbnail\"\r\n");
      out.write("                                    />\r\n");
      out.write("                                <img\r\n");
      out.write("                                    src=\"img/tm-img-100x100-5.jpg\"\r\n");
      out.write("                                    alt=\"Image\"\r\n");
      out.write("                                    class=\"tm-footer-thumbnail\"\r\n");
      out.write("                                    />\r\n");
      out.write("                                <img\r\n");
      out.write("                                    src=\"img/tm-img-100x100-6.jpg\"\r\n");
      out.write("                                    alt=\"Image\"\r\n");
      out.write("                                    class=\"tm-footer-thumbnail\"\r\n");
      out.write("                                    />\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <p class=\"tm-margin-b-20\">\r\n");
      out.write("                                Curabitur dui massa, aliquam quis mi sed, tempor vulputate\r\n");
      out.write("                                tellus. Sed vestibulum non neque.\r\n");
      out.write("                            </p>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-xs-12 tm-copyright-col\">\r\n");
      out.write("                        <p class=\"tm-copyright-text\">Copyright 2016 Your Company Name</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </footer>\r\n");
      out.write("\r\n");
      out.write("        <!-- load JS files -->\r\n");
      out.write("        <script src=\"js/jquery-1.11.3.min.js\"></script>\r\n");
      out.write("        <!-- jQuery (https://jquery.com/download/) -->\r\n");
      out.write("        <script src=\"https://www.atlasestateagents.co.uk/javascript/tether.min.js\"></script>\r\n");
      out.write("        <!-- Tether for Bootstrap, http://stackoverflow.com/questions/34567939/how-to-fix-the-error-error-bootstrap-tooltips-require-tether-http-github-h -->\r\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("        <!-- Bootstrap (http://v4-alpha.getbootstrap.com/) -->\r\n");
      out.write("        <script type=\"module\" src=\"https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js\"></script>\r\n");
      out.write("        <script nomodule src=\"https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js\"></script>\r\n");
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

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("booklist");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.booklist}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empty booklist}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                        <div>Cannot fetch book</div>\r\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setVar("i");
    _jspx_th_c_forEach_1.setBegin(0);
    _jspx_th_c_forEach_1.setEnd(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${counter - 1}", java.lang.Integer.class, (PageContext)_jspx_page_context, null)).intValue());
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                          <a href=\"BookController?page=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a>\r\n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_end_begin.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }
}
