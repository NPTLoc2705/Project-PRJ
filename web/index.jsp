<%@page import="java.util.List"%>
<%@page import="com.books.BookDTO"%>
<%@page import="com.User.UserDTO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <title>Stolen Books</title>
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
            />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" />
        <link rel="stylesheet" href="CSS/bootstrap.min.css" />
        <link rel="stylesheet" href="CSS/templatemo-style.css" />
        <link rel="stylesheet" href="CSS/nav.css" />
    </head>

    <body>
        <%@ include file="/nav.jsp" %>       
        <section class="tm-section">
            <div class="container-fluid">
                <div class="row">
                    
                </div>

                <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                <table>
                    <c:set var="booklist" value="${requestScope.booklist}" />
                    <c:if test="${not empty booklist}">
                        <c:forEach var="book" items="${booklist}">
                            <div class="book">
                                <img src="BookController?action=cover&filename=${book.cover}" alt="Living in the Light" />
                                <div class="book-details">
                                    <p class="book-title">${book.title}</p>
                                    <p class="book-meta">${book.description}</p>
                                    <div class="book-actions">

                                        <a href="./BookController?action=download&id=${book.bookID}"><button class>Download</button></a>
                                        <form action="Bookdetail">
                                            <button class="like-button">Detail</button>
                                            <input name="action" value="detail" type="hidden">
                                            <input name="bookid" value="${book.bookID}" type="hidden">
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty booklist}">
                        <div>Cannot fetch book</div>
                    </c:if>
                </table>
                <%
                    String spageid = request.getParameter("page");
                    int pageid = 0;
                    if (spageid != null) {
                        pageid = Integer.parseInt(spageid);
                    }
                %>
                <c:forEach var="i" begin="0" end="${counter - 1}">
                    <a href="BookController?page=${i}">${i}</a>
                </c:forEach>
        </section>
        <div class="footer">
            <footer class="tm-footer">

                <h1>SHARING BOOKS</h1>
                <p>Community shares useful content and knowledge about technology and entertainment.</p>
                <div class="contact-info">
                    <p>Contact Us</p>
                    <p><a href="tel:+84929526624">0961330320</a></p>
                    <p><a href="mailto:admin@linkneverdie.com">deadwiki@protonmail.com</a></p>                    
                </div>
            </footer>
        </div>
        <!-- load JS files -->
        <script src="js/jquery-1.11.3.min.js"></script>
        <script src="js/script.js"></script>
        <!-- jQuery (https://jquery.com/download/) -->
        <script src="https://www.atlasestateagents.co.uk/javascript/tether.min.js"></script>
        <!-- Tether for Bootstrap, http://stackoverflow.com/questions/34567939/how-to-fix-the-error-error-bootstrap-tooltips-require-tether-http-github-h -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Bootstrap (http://v4-alpha.getbootstrap.com/) -->
        <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    </body>
</html>
