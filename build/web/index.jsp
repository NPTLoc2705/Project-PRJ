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
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,400"
            />

        <link rel="stylesheet" href="CSS/bootstrap.min.css" />

        <link rel="stylesheet" href="CSS/templatemo-style.css" />


    </head>

    <body>

        <%@ include file="/nav.jsp" %>
        <div class="tm-home-img-container">
            <img
                src="img/1_6Jp3vJWe7VFlFHZ9WhSJng.jpg"
                alt="Image"
                class="hidden-lg-up img-fluid"
                />
        </div>

        <section class="tm-section">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-xs-center">
                        <h2 class="tm-gold-text tm-title">Introduction</h2>
                        <p class="tm-subtitle">
                            Suspendisse ut magna vel velit cursus tempor ut nec nunc. Mauris
                            vehicula, augue in tincidunt porta, purus ipsum blandit massa.
                        </p>
                    </div>
                </div>

                <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                <table>
                    <c:set var="booklist" value="${requestScope.booklist}" />
                    <c:if test="${not empty booklist}">
                        <c:forEach var="book" items="${booklist}">
                            <div class="book">
                                <img
                                    src="testy?filename=${book.cover}"
                                    alt="Living in the Light"
                                    />
                                <div class="book-details">
                                    <p class="book-title">
                                        ${book.title}
                                    </p>
                                    <p class="book-meta">${book.description}</p>
                                    <div class="book-actions">
                                        <button>Download</button>
                                        <button class="like-button"><a href="Bookdetail"> Detail</a></button>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty booklist}">
                        <div>Cannot fetch book</div>
                    </c:if>
                </table>
        </section>


        <footer class="tm-footer">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3">
                        <div class="tm-footer-content-box">
                            <h3 class="tm-gold-text tm-title tm-footer-content-box-title">
                                Proin eu posuere felis
                            </h3>
                            <div class="tm-gray-bg">
                                <img
                                    src="img/434253443_970851104438224_6556823117598086585_n.jpg"
                                    alt=""
                                    />
                                <p>Chủ khách sạn và sứ giả kết thân bạn tình</p>
                                <p><strong>Danny Egg (Executive)</strong></p>
                            </div>
                        </div>
                    </div>

                    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3">
                        <div class="tm-footer-content-box tm-footer-links-container">
                            <h3 class="tm-gold-text tm-title tm-footer-content-box-title">
                                Nulla tortor dolor
                            </h3>
                            <nav>
                                <ul class="nav">
                                    <li>
                                        <a href="#" class="tm-footer-link"
                                           >Tincidunt non faucibus</a
                                        >
                                    </li>
                                    <li>
                                        <a href="#" class="tm-footer-link">Vestibulum tempor</a>
                                    </li>
                                    <li>
                                        <a href="#" class="tm-footer-link"
                                           >Fusce non turpis euismod</a
                                        >
                                    </li>
                                    <li>
                                        <a href="#" class="tm-footer-link">Lorem ipsum dolor sit</a>
                                    </li>
                                    <li>
                                        <a href="#" class="tm-footer-link"
                                           >Nam in augue consectetur</a
                                        >
                                    </li>
                                    <li>
                                        <a href="#" class="tm-footer-link"
                                           >Text Link Color #CCCC66</a
                                        >
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>

                    <!-- Add the extra clearfix for only the required viewport 
                                  http://stackoverflow.com/questions/24590222/bootstrap-3-grid-with-different-height-in-each-item-is-it-solvable-using-only
                    -->
                    <div class="clearfix hidden-lg-up"></div>

                    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3">
                        <div class="tm-footer-content-box">
                            <h3 class="tm-gold-text tm-title tm-footer-content-box-title">
                                Etiam mollis ornare
                            </h3>
                            <p class="tm-margin-b-30">
                                Aenean cursus tellus mauris, quis consequat mauris dapibus id.
                                Donec scelerisque porttitor pharetra.
                            </p>
                            <hr class="tm-margin-b-30" />
                            <p class="tm-margin-b-30">
                                Aenean cursus tellus mauris, quis consequat mauris dapibus id.
                                Donec scelerisque porttitor pharetra.
                            </p>
                            <hr class="tm-margin-b-30" />
                            <p class="tm-margin-b-30">
                                Aenean cursus tellus mauris, quis consequat mauris dapibus id.
                                Donec scelerisque porttitor pharetra.
                            </p>

                        </div>
                    </div>

                    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3">
                        <div class="tm-footer-content-box">
                            <h3 class="tm-gold-text tm-title tm-footer-content-box-title">
                                Fusce non turpis
                            </h3>
                            <div class="tm-margin-b-30">
                                <img
                                    src="img/tm-img-100x100-1.jpg"
                                    alt="Image"
                                    class="tm-footer-thumbnail"
                                    />
                                <img
                                    src="img/tm-img-100x100-2.jpg"
                                    alt="Image"
                                    class="tm-footer-thumbnail"
                                    />
                                <img
                                    src="img/tm-img-100x100-3.jpg"
                                    alt="Image"
                                    class="tm-footer-thumbnail"
                                    />
                                <img
                                    src="img/tm-img-100x100-4.jpg"
                                    alt="Image"
                                    class="tm-footer-thumbnail"
                                    />
                                <img
                                    src="img/tm-img-100x100-5.jpg"
                                    alt="Image"
                                    class="tm-footer-thumbnail"
                                    />
                                <img
                                    src="img/tm-img-100x100-6.jpg"
                                    alt="Image"
                                    class="tm-footer-thumbnail"
                                    />
                            </div>
                            <p class="tm-margin-b-20">
                                Curabitur dui massa, aliquam quis mi sed, tempor vulputate
                                tellus. Sed vestibulum non neque.
                            </p>

                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-xs-12 tm-copyright-col">
                        <p class="tm-copyright-text">Copyright 2016 Your Company Name</p>
                    </div>
                </div>
            </div>
        </footer>

        <!-- load JS files -->
        <script src="js/jquery-1.11.3.min.js"></script>
        <!-- jQuery (https://jquery.com/download/) -->
        <script src="https://www.atlasestateagents.co.uk/javascript/tether.min.js"></script>
        <!-- Tether for Bootstrap, http://stackoverflow.com/questions/34567939/how-to-fix-the-error-error-bootstrap-tooltips-require-tether-http-github-h -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Bootstrap (http://v4-alpha.getbootstrap.com/) -->
        <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    </body>
</html>
