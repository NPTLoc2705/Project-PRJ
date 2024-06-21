package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.review.ReviewDTO;

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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> \r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n");
      out.write("        <title>Adventure messenger</title>  \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/bootstrap.min.css\" />\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"Adventure messengercss/navBar.css\"> \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/bookPage3.css\"> \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/templatemo-style.css\" /> \r\n");
      out.write("\r\n");
      out.write("        <script src=\"https://kit.fontawesome.com/bca396df6c.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"tm-header\">\r\n");
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
      out.write("\r\n");
      out.write("        <div class=\"movie-container\">\r\n");
      out.write("            <h1 class=\"movie-title\">Messenger of peace adventure notes and his suddenly stuck life</h1>\r\n");
      out.write("            <div class=\"movie-poster\">\r\n");
      out.write("                <img src=\"img/434253443_970851104438224_6556823117598086585_n.jpg\" alt=\"\"/>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"movie-details\">\r\n");
      out.write("                <p><strong>Director:</strong>Trần Sơn Triều</p>\r\n");
      out.write("                <p><strong>Actors:</strong> Tran Son Trieu, Nguyen Phan Tan Loc </p>\r\n");
      out.write("                <p><strong>Genre:</strong>Drama, Romantic, Horror, Hero, Sex Content</p>\r\n");
      out.write("                <p><strong>Opening:</strong>May 24, 2024</p>\r\n");
      out.write("                <p><strong>Language:</strong> Japanese - Vietnamese subtitles; Voiceover</p>\r\n");
      out.write("                <p><strong>Rate: STORY IS ALLOWED TO BE POPULAR TO READERS OF ALL AGES</strong>       \r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"action\">\r\n");
      out.write("                <div>\r\n");
      out.write("                    <a href=\"https://www.youtube.com/watch?v=qrBNq3isQOE&pp=ygUJZHUgdm8gbWF5\">\r\n");
      out.write("                        <i class=\"fa-regular fa-circle-play\"></i> Watch trailer\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>                \r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"buyTicket\">\r\n");
      out.write("                <a href=\"seat.html\" class=\"navbar-link btn-box\"> Download </a>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"synopsis\">\r\n");
      out.write("                <h2>Description book</h2>\r\n");
      out.write("                <p>In the distant past, there was a man named Tran Son Trieu. He was a fearless warrior with a noble purpose: to rid the world of the scourge known as the Jews. This man believed wholeheartedly in his cause and had been entrusted with a sacred mission by the gods themselves. His duty was to bring peace to the world by eradicating this malevolent force.\r\n");
      out.write("\r\n");
      out.write("                    Tran Son Trieu began his journey at an early age, honing his skills in battle and learning the secrets of his chosen path. As he grew older, he became increasingly aware of the threat posed by the Jews. They were said to be cunning, deceitful, and bent on destruction. Their very existence brought misery and suffering to countless innocents.\r\n");
      out.write("\r\n");
      out.write("                    With each passing day, Tran Son Trieu's resolve only strengthened. He knew that the time for action had come. He traveled far and wide, seeking out the most dangerous and influential Jewish leaders. With every strike, he felt closer to achieving his goal of global peace.\r\n");
      out.write("\r\n");
      out.write("                    His legendary prowess soon spread throughout the land. Many people admired him for his bravery and determination, while others feared him for the brutality with which he carried out his tasks. Regardless of public opinion, Tran Son Trieu remained steadfast in his belief that the Jews must be destroyed if the world was ever to know true harmony.\r\n");
      out.write("\r\n");
      out.write("                    As years passed, Tran Son Trieu's exploits grew more numerous and more spectacular. He faced countless challenges head-on, always emerging victorious. His enemies trembled before him, knowing full well that their days were numbered.</p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container_star\">\r\n");
      out.write("            <div class=\"post\">\r\n");
      out.write("                <div class=\"text\">Thanks for rating us!</div>\r\n");
      out.write("                <div class=\"edit\">EDIT</div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <form action=\"Bookdetail?action=submitReview\" method=\"post\">\r\n");
      out.write("                <div class=\"star-widget\">\r\n");
      out.write("                    <input type=\"radio\" name=\"rate\" value = \"5\" id=\"rate-5\">\r\n");
      out.write("                    <label for=\"rate-5\" class=\"fas fa-star\"></label>\r\n");
      out.write("                    <input type=\"radio\" name=\"rate\" value = \"4\" id=\"rate-4\">\r\n");
      out.write("                    <label for=\"rate-4\" class=\"fas fa-star\"></label>\r\n");
      out.write("                    <input type=\"radio\" name=\"rate\" value = \"3\"  id=\"rate-3\">\r\n");
      out.write("                    <label for=\"rate-3\" class=\"fas fa-star\"></label>\r\n");
      out.write("                    <input type=\"radio\" name=\"rate\" value =\"2\" id=\"rate-2\">\r\n");
      out.write("                    <label for=\"rate-2\" class=\"fas fa-star\"></label>\r\n");
      out.write("                    <input type=\"radio\" name=\"rate\" value =\"1\" id=\"rate-1\">\r\n");
      out.write("                    <label for=\"rate-1\" class=\"fas fa-star\"></label>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"textarea\">\r\n");
      out.write("                        <textarea name=\"comment\" cols=\"30\"  placeholder=\"Describe your experience..\"></textarea>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"post-btn\">\r\n");
      out.write("                        \r\n");
      out.write("                        <button type=\"submit\" class=\"rating-post-btn\">Post</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("            </form>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("<table>\r\n");
      out.write("    ");

       
        List<ReviewDTO> list = (List<ReviewDTO>) request.getAttribute("reviewList");
        if (list != null && !list.isEmpty()) {
            for (ReviewDTO reviews : list) {
                
    
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>");
      out.print( reviews.getUserName() );
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print( reviews.getRating() );
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print( reviews.getComment() );
      out.write("</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("    ");

            }
        } else {
    
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td colspan=\"3\">No reviews available.</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("    ");

        }
    
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("\r\n");
      out.write("        const ratingPostBtn = document.querySelector(\".rating-post-btn\");\r\n");
      out.write("        const post = document.querySelector(\".post\");\r\n");
      out.write("        const widget = document.querySelector(\".star-widget\");\r\n");
      out.write("        const editBtn = document.querySelector(\".edit\");\r\n");
      out.write("\r\n");
      out.write("        ratingPostBtn.onclick = (e) => {\r\n");
      out.write("            e.preventDefault();\r\n");
      out.write("            widget.style.display = \"none\";\r\n");
      out.write("            post.style.display = \"block\";\r\n");
      out.write("            document.querySelector(\"form\").submit();\r\n");
      out.write("\r\n");
      out.write("            editBtn.onclick = () => {\r\n");
      out.write("                widget.style.display = \"block\";\r\n");
      out.write("                post.style.display = \"none\";\r\n");
      out.write("            };\r\n");
      out.write("        };\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("    <!-- load JS files -->\r\n");
      out.write("    <script src=\"js/jquery-1.11.3.min.js\"></script>\r\n");
      out.write("    <!-- jQuery (https://jquery.com/download/) -->\r\n");
      out.write("    <script src=\"https://www.atlasestateagents.co.uk/javascript/tether.min.js\"></script>\r\n");
      out.write("    <!-- Tether for Bootstrap, http://stackoverflow.com/questions/34567939/how-to-fix-the-error-error-bootstrap-tooltips-require-tether-http-github-h -->\r\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("    <!-- Bootstrap (http://v4-alpha.getbootstrap.com/) -->\r\n");
      out.write("    <script type=\"module\" src=\"https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js\"></script>\r\n");
      out.write("    <script nomodule src=\"https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js\"></script>\r\n");
      out.write("</body>\r\n");
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
