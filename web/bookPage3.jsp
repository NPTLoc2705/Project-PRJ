<%@page import="com.User.UserDTO"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.review.ReviewDTO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Adventure messenger</title>  
        <link rel="stylesheet" href="CSS/bootstrap.min.css" />
        <link rel="stylesheet" href="Adventure messengercss/navBar.css"> 
        <link rel="stylesheet" href="CSS/bookPage3.css"> 
        <link rel="stylesheet" href="CSS/templatemo-style.css" /> 
        <link rel="stylesheet" href="CSS/nav.css" /> 
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
            />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" />

        <script src="https://kit.fontawesome.com/bca396df6c.js" crossorigin="anonymous"></script>
    </head>

    <body>

        <%@page import="com.User.UserDTO"%>
        <nav class="navbar">
            <div class="navbar-logo">
                <a href="BookController"><img src="img/hinh.png"  alt="logo" /></a>
            </div>
            <ul class="navbar-list">
                <li><a href="BookController">Home</a></li>
                <li><a href="FileUpload.jsp">Upload</a></li>


            </ul>

            <% HttpSession sessions = request.getSession(false);

                if (sessions.getAttribute(
                        "loginSession") != null) {%>

            <div class="profile-dropdown">
                <div onclick="toggle()" class="profile-dropdown-btn">
                    <div class="profile-img">

                    </div>
                    <span
                        >${sessionScope.loginSession.username}
                        <i class="fa-solid fa-angle-down"></i>
                    </span>
                </div>
                <ul class="profile-dropdown-list">
                    <li class="profile-dropdown-list-item">
                        <a href="Login?action=detail&id=${requestScope.userID}">                    
                            User Profile
                        </a>
                    </li>
                    <% UserDTO user = (UserDTO) session.getAttribute("loginSession");
                        if (user != null
                                && user.isAdmin()) { %>
                    <li class="profile-dropdown-list-item">
                        <a href="./admin?action=list">Go to Admin Page</a>
                    </li>
                    <% }%>
                    <li class="profile-dropdown-list-item">
                        <a href="Login?action=signout"> Log out </a>
                    </li>
                </ul>
            </div>

            <%} else {%>

            <li><a href="Login.jsp">Sign In</a></li>

            <%}%>

        </nav>



        <div class="movie-container">
            <h1 class="movie-title">${requestScope.object.title}</h1>
            <div class="movie-poster">
                <img src="./BookController?action=cover&filename=${object.cover}" alt=""/>
            </div>
            <div class="movie-details">
                <p><strong>Author:</strong>${requestScope.object.author}</p>
                <p><strong>Uploaded by:</strong>${requestScope.object.username}</p>
                <p><strong>Genre:</strong>Drama, Romantic, Horror, Hero</p>
                <p><strong>Rate:</strong> ${requestScope.object.averageRating}</p>
            </div>
            <div class="buyTicket">
                <a href="./BookController?action=download&id=${requestScope.object.bookID}" class="navbar-link btn-box"> Download </a>
            </div>

            <div class="synopsis">
                <h2>Description book</h2>
                <p>${requestScope.object.description}.</p>
            </div>
        </div>

        <div class="container_star">
            <div class="post">
                <div class="text">Thanks for rating us!</div>
                <div class="edit">EDIT</div>
            </div>
            <form action="Bookdetail?action=submitReview&id=${object.bookID}" method="post">
                <div class="star-widget">
                    <input type="radio" name="rate" value = "5" id="rate-5">
                    <label for="rate-5" class="fas fa-star"></label>
                    <input type="radio" name="rate" value = "4" id="rate-4">
                    <label for="rate-4" class="fas fa-star"></label>
                    <input type="radio" name="rate" value = "3"  id="rate-3">
                    <label for="rate-3" class="fas fa-star"></label>
                    <input type="radio" name="rate" value ="2" id="rate-2">
                    <label for="rate-2" class="fas fa-star"></label>
                    <input type="radio" name="rate" value ="1" id="rate-1">
                    <label for="rate-1" class="fas fa-star"></label>

                    <div class="textarea">
                        <textarea name="comment" cols="30"  placeholder="Describe your experience.."></textarea>
                    </div>
                    <div class="post-btn">

                        <button type="submit" class="rating-post-btn">Post</button>
                    </div>
            </form>


        </div>
    </div>

    <div class="testimonial-box-container">
        <%
            List<ReviewDTO> list = (List<ReviewDTO>) request.getAttribute("reviewList");
            if (list != null) {
                for (ReviewDTO review : list) {
                    pageContext.setAttribute("review", review);
        %>
        <!--BOX-1-------------->
        <div class="testimonial-box">
            <!--top------------------------->
            <div class="box-top">
                <!--profile----->
                <div class="profile">
                    <!--img---->
                    <div class="profile-img">

                    </div>
                    <!--name-and-username-->
                    <div class="name-user">
                        <p class="username"><%= review.getUserName()%></p>
                    </div>
                </div>
                <!--reviews------>
                <div class="reviews">
                    <p class="rating">
                        <%
                            int rating = review.getRating();
                            // Hiển thị sao đầy
                            for (int i = 0; i < rating; i++) {
                        %>
                        <span class="star">&#9733;</span> <!-- Sao đầy -->
                        <%
                            }
                            // Hiển thị sao trống
                            for (int i = rating; i < 5; i++) {
                        %>
                        <span class="star" style="color: #ddd;">&#9733;</span> <!-- Sao trống -->
                        <%
                            }
                        %>
                    </p>
                </div>
            </div>
            <div class="client-comment">
                <p><%= review.getComment()%></p>
            </div>
        </div>
        <form action="Bookdetail?id=${object.bookID}" method="POST">
            <input name="action" value="delete" type="hidden">
            <input name="reviewid" value="${review.reviewID}" type="hidden">
            <input type="submit" value="Delete">
        </form>

        <%
            }
        } else {
        %>
        <p>No reviews available.</p> 
        <%
            }
        %>
    </div>


    <script>

        const ratingPostBtn = document.querySelector(".rating-post-btn");
        const post = document.querySelector(".post");
        const widget = document.querySelector(".star-widget");
        const editBtn = document.querySelector(".edit");

        ratingPostBtn.onclick = (e) => {
            e.preventDefault();
            widget.style.display = "none";
            post.style.display = "block";
            document.querySelector("form").submit();

            editBtn.onclick = () => {
                widget.style.display = "block";
                post.style.display = "none";
            };
        };

    </script>

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
