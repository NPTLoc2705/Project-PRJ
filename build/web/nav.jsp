<%@page import="com.User.UserDTO"%>
<div class="tm-header">
            <div class="container-fluid">
                <div class="tm-header-inner">
                    <div class="tm-header-logo">
                        <a href="BookController" class="navbar-brand tm-site-name"
                           ><img src="img/hinh.png" alt=""
                              /></a>
                    </div>

                    <!-- navbar -->
                    <nav class="navbar tm-main-nav">
                        <button
                            class="navbar-toggler hidden-md-up"
                            type="button"
                            data-toggle="collapse"
                            data-target="#tmNavbar"
                            >
                            &#9776;
                        </button>

                        <div class="collapse navbar-toggleable-sm" id="tmNavbar">
                            <ul class="nav navbar-nav">
                                <div class ="search-box">
                                    <form action="BookController" method="GET">
                                        <input class="search-box-input" type="text" name="keyword" value="<%=request.getParameter("keyword") != null ? request.getParameter("keyword") : ""%>">
                                        <button class="search-box-bth" type="submit" value="search"><ion-icon name="search-outline"></ion-icon></button>
                                    </form>

                                </div>
                                <li class="nav-item ">
                                    <a href="index.jsp" class="nav-link">Home</a>
                                </li>
                                <li class="nav-item">
                                    <a href="FileUpload.jsp" class="nav-link">Upload</a>
                                </li>
                                <% UserDTO user = (UserDTO) request.getAttribute("session");
                                    if (user != null) {
                                %>
                                <li class="nav-item">
                                    <a href="Login.jsp" class="nav-link">Sign out</a>
                                    <% } else {%>
                                <li class="nav-item">
                                    <a href="Login.jsp" class="nav-link">Sign up</a>
                                    <% }%>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
        </div>