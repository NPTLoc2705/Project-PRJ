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

        <script src="https://kit.fontawesome.com/bca396df6c.js" crossorigin="anonymous"></script>
    </head>

    <body>
   
        <div class="tm-header">
            <div class="container-fluid">
                <div class="tm-header-inner">
                    <div class="tm-header-logo">
                        <a href="#" class="navbar-brand tm-site-name"
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
                                    <input class="search-box-input" type="text">
                                    <button class="search-box-bth" type="submit"><ion-icon name="search-outline"></ion-icon></button>

                                </div>
                                <li class="nav-item active">
                                    <a href="index.html" class="nav-link">Home</a>
                                </li>
                                <li class="nav-item">
                                    <a href="about.html" class="nav-link">About</a>
                                </li>
                                <li class="nav-item">
                                    <a href="Login.jsp" class="nav-link">Sign up</a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
        </div>

        <div class="movie-container">
            <h1 class="movie-title">Messenger of peace adventure notes and his suddenly stuck life</h1>
            <div class="movie-poster">
                <img src="img/434253443_970851104438224_6556823117598086585_n.jpg" alt=""/>
            </div>
            <div class="movie-details">
                <p><strong>Director:</strong>Trần Sơn Triều</p>
                <p><strong>Actors:</strong> Tran Son Trieu, Nguyen Phan Tan Loc </p>
                <p><strong>Genre:</strong>Drama, Romantic, Horror, Hero, Sex Content</p>
                <p><strong>Opening:</strong>May 24, 2024</p>
                <p><strong>Language:</strong> Japanese - Vietnamese subtitles; Voiceover</p>
                <p><strong>Rate: STORY IS ALLOWED TO BE POPULAR TO READERS OF ALL AGES</strong>       
            </div>

            <div class="action">
                <div>
                    <a href="https://www.youtube.com/watch?v=qrBNq3isQOE&pp=ygUJZHUgdm8gbWF5">
                        <i class="fa-regular fa-circle-play"></i> Watch trailer
                    </a>
                </div>                
            </div>

            <div class="buyTicket">
                <a href="seat.html" class="navbar-link btn-box"> Download </a>
            </div>

            <div class="synopsis">
                <h2>Description book</h2>
                <p>In the distant past, there was a man named Tran Son Trieu. He was a fearless warrior with a noble purpose: to rid the world of the scourge known as the Jews. This man believed wholeheartedly in his cause and had been entrusted with a sacred mission by the gods themselves. His duty was to bring peace to the world by eradicating this malevolent force.

                    Tran Son Trieu began his journey at an early age, honing his skills in battle and learning the secrets of his chosen path. As he grew older, he became increasingly aware of the threat posed by the Jews. They were said to be cunning, deceitful, and bent on destruction. Their very existence brought misery and suffering to countless innocents.

                    With each passing day, Tran Son Trieu's resolve only strengthened. He knew that the time for action had come. He traveled far and wide, seeking out the most dangerous and influential Jewish leaders. With every strike, he felt closer to achieving his goal of global peace.

                    His legendary prowess soon spread throughout the land. Many people admired him for his bravery and determination, while others feared him for the brutality with which he carried out his tasks. Regardless of public opinion, Tran Son Trieu remained steadfast in his belief that the Jews must be destroyed if the world was ever to know true harmony.

                    As years passed, Tran Son Trieu's exploits grew more numerous and more spectacular. He faced countless challenges head-on, always emerging victorious. His enemies trembled before him, knowing full well that their days were numbered.</p>
            </div>
        </div>

        <div class="container_star">
            <div class="post">
                <div class="text">Thanks for rating us!</div>
                <div class="edit">EDIT</div>
            </div>
            <form action="Bookdetail?action=submitReview" method="post">
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
            <!--Comments---------------------------------------->
            <div class="client-comment">
                <p><%= review.getComment()%></p>
            </div>
        </div>
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
    <!-- jQuery (https://jquery.com/download/) -->
    <script src="https://www.atlasestateagents.co.uk/javascript/tether.min.js"></script>
    <!-- Tether for Bootstrap, http://stackoverflow.com/questions/34567939/how-to-fix-the-error-error-bootstrap-tooltips-require-tether-http-github-h -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Bootstrap (http://v4-alpha.getbootstrap.com/) -->
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>
