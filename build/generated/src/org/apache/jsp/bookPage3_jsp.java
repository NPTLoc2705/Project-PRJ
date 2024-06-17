package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class bookPage3_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html> \n");
      out.write("<html lang=\"en\" dir=\"ltr\">\n");
      out.write("    <head> \n");
      out.write("        <title>Adventure messenger</title> \n");
      out.write("        <meta charset=\"UTF-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> \n");
      out.write("        <link rel=\"stylesheet\" href=\"Adventure messengercss/navBar.css\"> \n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/footer.css\"> \n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/bookPage3.css\"> \n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/templatemo-style.css\" /> \n");
      out.write("        <script src=\"https://kit.fontawesome.com/bca396df6c.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("  <body>\n");
      out.write("        <div class=\"tm-header\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"tm-header-inner\">\n");
      out.write("                    <div class=\"tm-header-logo\">\n");
      out.write("                        <a href=\"#\" class=\"navbar-brand tm-site-name\"\n");
      out.write("                           ><img src=\"img/hinh.png\" alt=\"\"\n");
      out.write("                              /></a>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <!-- navbar -->\n");
      out.write("                    <nav class=\"navbar tm-main-nav\">\n");
      out.write("                        <button\n");
      out.write("                            class=\"navbar-toggler hidden-md-up\"\n");
      out.write("                            type=\"button\"\n");
      out.write("                            data-toggle=\"collapse\"\n");
      out.write("                            data-target=\"#tmNavbar\"\n");
      out.write("                            >\n");
      out.write("                            &#9776;\n");
      out.write("                        </button>\n");
      out.write("\n");
      out.write("                        <div class=\"collapse navbar-toggleable-sm\" id=\"tmNavbar\">\n");
      out.write("                            <ul class=\"nav navbar-nav\">\n");
      out.write("                                <div class =\"search-box\">\n");
      out.write("                                    <input class=\"search-box-input\" type=\"text\">\n");
      out.write("                                    <button class=\"search-box-bth\" type=\"submit\"><ion-icon name=\"search-outline\"></ion-icon></button>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <li class=\"nav-item active\">\n");
      out.write("                                    <a href=\"index.html\" class=\"nav-link\">Home</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <a href=\"about.html\" class=\"nav-link\">About</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li class=\"nav-item\">\n");
      out.write("                                    <a href=\"Login.jsp\" class=\"nav-link\">Sign up</a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("            <div class=\"movie-container\">\n");
      out.write("                <h1 class=\"movie-title\">Messenger of peace adventure notes and his suddenly stuck life</h1>\n");
      out.write("                <div class=\"movie-poster\">x\n");
      out.write("                    <img src=\"img/434253443_970851104438224_6556823117598086585_n.jpg\" alt=\"\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"movie-details\">\n");
      out.write("                    <p><strong>Director:</strong>Tran Son Trieu</p>\n");
      out.write("                    <p><strong>Actors:</strong> Tran Son Trieu, Nguyen Phan Tan Loc</p>\n");
      out.write("                    <p><strong>Genre:</strong>Drama, Romantic, Horror, Hero, Sex Content</p>\n");
      out.write("                    <p><strong>Opening:</strong>May 24, 2024</p>\n");
      out.write("                    <p><strong>Language:</strong> Japanese - Vietnamese subtitles; Voiceover</p>\n");
      out.write("                    <p><strong>Rate: STORY IS ALLOWED TO BE POPULAR TO READERS OF ALL AGES</strong>     \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"action\">\n");
      out.write("                    <div>\n");
      out.write("                        <a href=\"https://www.youtube.com/watch?v=Rlx2E9Hr7gI\">\n");
      out.write("                            <i class=\"fa-regular fa-circle-play\"></i> watch trailer\n");
      out.write("                        </a>\n");
      out.write("                    </div>                \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"buyTicket\">\n");
      out.write("                    <a href=\"seat.html\" class=\"navbar-link btn-box\"> Download </a>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"synopsis\">\n");
      out.write("                    <h2>Description book</h2>\n");
      out.write("                    <p>In the distant past, there was a man named Tran Son Trieu. He was a fearless warrior with a noble purpose: to rid the world of the scourge known as the Jews. This man believed wholeheartedly in his cause and had been entrusted with a sacred mission by the gods themselves. His duty was to bring peace to the world by eradicating this malevolent force.\n");
      out.write("\n");
      out.write("                        Tran Son Trieu began his journey at an early age, honing his skills in battle and learning the secrets of his chosen path. As he grew older, he became increasingly aware of the threat posed by the Jews. They were said to be cunning, deceitful, and bent on destruction. Their very existence brought misery and suffering to countless innocents.\n");
      out.write("\n");
      out.write("                        With each passing day, Tran Son Trieu's resolve only strengthened. He knew that the time for action had come. He traveled far and wide, seeking out the most dangerous and influential Jewish leaders. With every strike, he felt closer to achieving his goal of global peace.\n");
      out.write("\n");
      out.write("                        His legendary prowess soon spread throughout the land. Many people admired him for his bravery and determination, while others feared him for the brutality with which he carried out his tasks. Regardless of public opinion, Tran Son Trieu remained steadfast in his belief that the Jews must be destroyed if the world was ever to know true harmony.\n");
      out.write("\n");
      out.write("                        As years passed, Tran Son Trieu's exploits grew more numerous and more spectacular. He faced countless challenges head-on, always emerging victorious. His enemies trembled before him, knowing full well that their days were numbered.p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"container_star\">\n");
      out.write("                <div class=\"post\">\n");
      out.write("                    <div class=\"text\">Thanks for rating us!</div>\n");
      out.write("                    <div class=\"edit\">EDIT</div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"star-widget\">\n");
      out.write("                    <input type=\"radio\" name=\"rate\" id=\"rate-5\">\n");
      out.write("                    <label for=\"rate-5\" class=\"fas fa-star\"></label>\n");
      out.write("                    <input type=\"radio\" name=\"rate\" id=\"rate-4\">\n");
      out.write("                    <label for=\"rate-4\" class=\"fas fa-star\"></label>\n");
      out.write("                    <input type=\"radio\" name=\"rate\" id=\"rate-3\">\n");
      out.write("                    <label for=\"rate-3\" class=\"fas fa-star\"></label>\n");
      out.write("                    <input type=\"radio\" name=\"rate\" id=\"rate-2\">\n");
      out.write("                    <label for=\"rate-2\" class=\"fas fa-star\"></label>\n");
      out.write("                    <input type=\"radio\" name=\"rate\" id=\"rate-1\">\n");
      out.write("                    <label for=\"rate-1\" class=\"fas fa-star\"></label>\n");
      out.write("                    <form action=\"#\">\n");
      out.write("                        <header></header>\n");
      out.write("                        <div class=\"textarea\">\n");
      out.write("                            <textarea cols=\"30\" placeholder=\"Describe your experience..\"></textarea>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"post-btn\">\n");
      out.write("                            <button type=\"submit\" class=\"rating-post-btn\">Post</button>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <script>\n");
      out.write("    \n");
      out.write("                const ratingPostBtn = document.querySelector(\".rating-post-btn\");\n");
      out.write("                const post = document.querySelector(\".post\");\n");
      out.write("                const widget = document.querySelector(\".star-widget\");\n");
      out.write("                const editBtn = document.querySelector(\".edit\");\n");
      out.write("\n");
      out.write("                ratingPostBtn.onclick = (e) => {\n");
      out.write("                    e.preventDefault();\n");
      out.write("                    widget.style.display = \"none\";\n");
      out.write("                    post.style.display = \"block\";\n");
      out.write("\n");
      out.write("                    editBtn.onclick = () => {\n");
      out.write("                        widget.style.display = \"block\";\n");
      out.write("                        post.style.display = \"none\";\n");
      out.write("                    };\n");
      out.write("                };\n");
      out.write("            </script>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
